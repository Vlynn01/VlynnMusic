package com.vlynn.data.mediaservice

import com.vlynn.domain.repository.AnalyticsRepository

actual fun createMediaServiceHandler(
    dataStoreManager: com.vlynn.domain.manager.DataStoreManager,
    songRepository: com.vlynn.domain.repository.SongRepository,
    streamRepository: com.vlynn.domain.repository.StreamRepository,
    localPlaylistRepository: com.vlynn.domain.repository.LocalPlaylistRepository,
    analyticsRepository: AnalyticsRepository,
    coroutineScope: kotlinx.coroutines.CoroutineScope,
): com.vlynn.domain.mediaservice.handler.MediaPlayerHandler =
    MediaServiceHandlerImpl(
        dataStoreManager,
        songRepository,
        streamRepository,
        localPlaylistRepository,
        analyticsRepository,
        coroutineScope,
    )