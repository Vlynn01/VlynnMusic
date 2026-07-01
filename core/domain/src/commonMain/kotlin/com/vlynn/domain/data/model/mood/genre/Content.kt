package com.vlynn.domain.data.model.mood.genre

import com.vlynn.domain.data.model.searchResult.songs.Thumbnail
import com.vlynn.domain.data.type.HomeContentType

data class Content(
    val playlistBrowseId: String,
    val thumbnail: List<Thumbnail>?,
    val title: Title,
) : HomeContentType