package com.vlynn.domain.data.model.account

import com.vlynn.domain.data.model.searchResult.songs.Thumbnail

data class AccountInfo(
    val name: String,
    val email: String,
    val pageId: String? = null,
    val thumbnails: List<Thumbnail>,
)