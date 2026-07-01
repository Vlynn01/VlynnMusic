package com.vlynn.kotlinytmusicscraper.pages

import com.vlynn.kotlinytmusicscraper.models.SongItem

data class PlaylistContinuationPage(
    val songs: List<SongItem>,
    val continuation: String?,
)