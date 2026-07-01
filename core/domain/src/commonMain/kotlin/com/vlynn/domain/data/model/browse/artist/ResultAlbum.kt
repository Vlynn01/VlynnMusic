package com.vlynn.domain.data.model.browse.artist

import com.vlynn.domain.data.model.searchResult.songs.Thumbnail
import com.vlynn.domain.data.type.HomeContentType

data class ResultAlbum(
    val browseId: String,
    val isExplicit: Boolean,
    val thumbnails: List<Thumbnail>,
    val title: String,
    val year: String,
) : HomeContentType