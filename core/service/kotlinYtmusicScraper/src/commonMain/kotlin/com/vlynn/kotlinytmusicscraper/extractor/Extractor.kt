package com.vlynn.kotlinytmusicscraper.extractor

import com.vlynn.kotlinytmusicscraper.models.SongItem
import com.vlynn.kotlinytmusicscraper.models.response.DownloadProgress

expect class Extractor() {
    fun init()

    fun logIn(cookie: String?)

    fun mergeAudioVideoDownload(filePath: String): DownloadProgress

    fun saveAudioWithThumbnail(
        filePath: String,
        track: SongItem,
    ): DownloadProgress

    fun newPipePlayer(videoId: String): List<Pair<Int, String>>
}