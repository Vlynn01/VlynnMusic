package com.vlynn.kotlinytmusicscraper.models.response

import com.vlynn.kotlinytmusicscraper.models.PlaylistPanelRenderer
import kotlinx.serialization.Serializable

@Serializable
data class GetQueueResponse(
    val queueDatas: List<QueueData>,
) {
    @Serializable
    data class QueueData(
        val content: PlaylistPanelRenderer.Content,
    )
}