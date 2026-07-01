package com.vlynn.domain.data.model.mood.moodmoments

import com.vlynn.domain.data.model.searchResult.songs.Thumbnail
import com.vlynn.domain.data.type.HomeContentType

data class Content(
    val playlistBrowseId: String,
    val subtitle: String,
    val thumbnails: List<Thumbnail>?,
    val title: String,
) : HomeContentType