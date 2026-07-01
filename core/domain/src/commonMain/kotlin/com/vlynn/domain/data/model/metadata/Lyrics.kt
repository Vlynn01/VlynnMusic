package com.vlynn.domain.data.model.metadata

import kotlinx.serialization.Serializable

@Serializable
data class Lyrics(
    val error: Boolean = false,
    val lines: List<Line>?,
    val syncType: String?,
    val simpMusicLyrics: VlynnMusicLyrics? = null,
)

@Serializable
data class VlynnMusicLyrics(
    val id: String,
    val vote: Int,
)