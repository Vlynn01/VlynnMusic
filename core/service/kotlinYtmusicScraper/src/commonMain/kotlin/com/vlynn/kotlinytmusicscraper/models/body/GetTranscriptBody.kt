package com.vlynn.kotlinytmusicscraper.models.body

import com.vlynn.kotlinytmusicscraper.models.Context
import kotlinx.serialization.Serializable

@Serializable
data class GetTranscriptBody(
    val context: Context,
    val params: String,
)