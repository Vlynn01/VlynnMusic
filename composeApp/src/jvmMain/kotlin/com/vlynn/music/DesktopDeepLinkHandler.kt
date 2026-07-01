package com.vlynn.music

import com.eygraber.uri.Uri
import com.vlynn.domain.data.model.intent.GenericIntent
import com.vlynn.logger.Logger
import java.io.File

/**
 * Singleton to handle deep link URIs on Desktop.
 * Caches URI if app UI is not ready yet, delivers immediately if listener is set.
 *
 * Also provides file-based IPC for single-instance deep link forwarding:
 * when a second instance launches with a URI, it writes the URI to a temp file,
 * and the first instance reads it on restore.
 *
 * Supported URI patterns:
 * - vlynnmusic://open-app?url=<encoded_url>  (redirected from website)
 * - vlynnmusic://watch?v=VIDEO_ID            (direct scheme)
 * - vlynnmusic://playlist?list=PLAYLIST_ID   (direct scheme)
 * - vlynnmusic://channel/CHANNEL_ID          (direct scheme)
 * - vlynnmusic://album?id=ALBUM_ID           (direct scheme)
 * - https://vlynnmusic.org/app/...            (web URL passed via args)
 */
object DesktopDeepLinkHandler {
    private const val TAG = "DesktopDeepLinkHandler"

    private val pendingUriFile: File by lazy {
        File(System.getProperty("java.io.tmpdir"), "vlynnmusic_pending_deeplink.txt")
    }

    private var cached: String? = null

    var listener: ((GenericIntent) -> Unit)? = null
        set(value) {
            field = value
            if (value != null) {
                cached?.let { uri ->
                    Logger.d(TAG, "Delivering cached URI: $uri")
                    value.invoke(parseToIntent(uri))
                    cached = null
                }
            }
        }

    fun onNewUri(uri: String) {
        Logger.d(TAG, "Received URI: $uri")
        val intent = parseToIntent(uri)
        val currentListener = listener
        if (currentListener != null) {
            currentListener.invoke(intent)
            cached = null
        } else {
            Logger.d(TAG, "Listener not ready, caching URI: $uri")
            cached = uri
        }
    }

    /**
     * Write URI to a temp file so the running (first) instance can pick it up.
     * Called by the second instance before it exits.
     */
    fun writePendingUri(uri: String) {
        try {
            pendingUriFile.writeText(uri)
            Logger.d(TAG, "Wrote pending URI to file: $uri")
        } catch (e: Exception) {
            Logger.e(TAG, "Failed to write pending URI: ${e.message}")
        }
    }

    /**
     * Read and consume the pending URI file written by a second instance.
     * Called by the first instance when it receives a restore request.
     */
    fun consumePendingUri() {
        try {
            if (pendingUriFile.exists()) {
                val uri = pendingUriFile.readText().trim()
                pendingUriFile.delete()
                if (uri.isNotEmpty()) {
                    Logger.d(TAG, "Consumed pending URI from file: $uri")
                    onNewUri(uri)
                }
            }
        } catch (e: Exception) {
            Logger.e(TAG, "Failed to read pending URI: ${e.message}")
        }
    }

    /**
     * Converts a raw URI string into a [GenericIntent] that App.kt can process.
     *
     * Conversion rules:
     * 1. vlynnmusic://open-app?url=<encoded_url>
     *    → Extract the `url` param and use it as intent data
     *
     * 2. vlynnmusic://watch?v=xxx, vlynnmusic://playlist?list=xxx, etc.
     *    → Convert to https://vlynnmusic.org/app/watch?v=xxx format
     *      so App.kt handles it uniformly via the vlynnmusic.org branch
     *
     * 3. https://vlynnmusic.org/app/... or YouTube URLs
     *    → Pass through as-is
     */
    private fun parseToIntent(uri: String): GenericIntent {
        val parsed = Uri.parse(uri)

        val actualUri = when {
            // vlynnmusic://open-app?url=<encoded_url>
            parsed.scheme == "vlynnmusic" && parsed.host == "open-app" -> {
                val urlParam = parsed.getQueryParameter("url")
                if (urlParam != null) {
                    Logger.d(TAG, "Extracted URL from open-app: $urlParam")
                    Uri.parse(urlParam)
                } else {
                    // vlynnmusic://open-app without params → just open the app, no navigation
                    Logger.d(TAG, "open-app without URL param, just opening app")
                    null
                }
            }

            // vlynnmusic://watch?v=xxx → https://vlynnmusic.org/app/watch?v=xxx
            // vlynnmusic://playlist?list=xxx → https://vlynnmusic.org/app/playlist?list=xxx
            // vlynnmusic://channel/UCxxx → https://vlynnmusic.org/app/channel/UCxxx
            // vlynnmusic://album?id=xxx → https://vlynnmusic.org/app/album?id=xxx
            parsed.scheme == "vlynnmusic" && parsed.host != null -> {
                val host = parsed.host!!
                val query = parsed.query?.let { "?$it" } ?: ""
                val pathSuffix = parsed.pathSegments.joinToString("/").let {
                    if (it.isNotEmpty()) "/$it" else ""
                }
                val convertedUrl = "https://vlynnmusic.org/app/$host$pathSuffix$query"
                Logger.d(TAG, "Converted vlynnmusic:// to: $convertedUrl")
                Uri.parse(convertedUrl)
            }

            // https://vlynnmusic.org/app/... or YouTube URLs → pass through
            else -> parsed
        }

        return if (actualUri != null) {
            GenericIntent(
                action = "android.intent.action.VIEW",
                data = actualUri,
            )
        } else {
            // No data → just triggers app restore, no navigation
            GenericIntent(action = "android.intent.action.VIEW")
        }
    }
}
