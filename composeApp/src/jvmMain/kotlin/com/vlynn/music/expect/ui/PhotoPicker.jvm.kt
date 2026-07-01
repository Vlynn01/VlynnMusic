package com.vlynn.music.expect.ui

import androidx.compose.runtime.Composable

@Composable
actual fun photoPickerResult(onResultUri: (String?) -> Unit): PhotoPickerLauncher =
    object : PhotoPickerLauncher {
        override fun launch() {
            onResultUri(null)
        }
    }