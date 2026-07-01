package com.vlynn.data.mediaservice

import com.vlynn.domain.manager.DataStoreManager
import com.vlynn.domain.mediaservice.handler.MediaPlayerHandler
import com.vlynn.domain.repository.AnalyticsRepository
import com.vlynn.domain.repository.LocalPlaylistRepository
import com.vlynn.domain.repository.SongRepository
import com.vlynn.domain.repository.StreamRepository
import kotlinx.coroutines.CoroutineScope

expect fun createMediaServiceHandler(
    dataStoreManager: DataStoreManager,
    songRepository: SongRepository,
    streamRepository: StreamRepository,
    localPlaylistRepository: LocalPlaylistRepository,
    analyticsRepository: AnalyticsRepository,
    coroutineScope: CoroutineScope,
): MediaPlayerHandler