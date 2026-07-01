package com.vlynn.kotlinytmusicscraper.pages

import com.vlynn.kotlinytmusicscraper.models.AlbumItem
import com.vlynn.kotlinytmusicscraper.models.VideoItem

data class ExplorePage(
    val released: List<AlbumItem>,
    val musicVideo: List<VideoItem>,
)