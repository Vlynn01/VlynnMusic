package com.vlynn.data.mediaservice

actual fun createMediaServiceHandler(
    dataStoreManager: com.vlynn.domain.manager.DataStoreManager,
    songRepository: com.vlynn.domain.repository.SongRepository,
    streamRepository: com.vlynn.domain.repository.StreamRepository,
    localPlaylistRepository: com.vlynn.domain.repository.LocalPlaylistRepository,
    analyticsRepository: com.vlynn.domain.repository.AnalyticsRepository,
    coroutineScope: kotlinx.coroutines.CoroutineScope,
): com.vlynn.domain.mediaservice.handler.MediaPlayerHandler {
    TODO("Not yet implemented")
}