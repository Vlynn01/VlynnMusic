package com.vlynn.data.di

import com.vlynn.common.Config.SERVICE_SCOPE
import com.vlynn.data.io.fileDir
import com.vlynn.data.repository.AccountRepositoryImpl
import com.vlynn.data.repository.AlbumRepositoryImpl
import com.vlynn.data.repository.AnalyticsRepositoryImpl
import com.vlynn.data.repository.ArtistRepositoryImpl
import com.vlynn.data.repository.CommonRepositoryImpl
import com.vlynn.data.repository.HomeRepositoryImpl
import com.vlynn.data.repository.LocalPlaylistRepositoryImpl
import com.vlynn.data.repository.LyricsCanvasRepositoryImpl
import com.vlynn.data.repository.PlaylistRepositoryImpl
import com.vlynn.data.repository.PodcastRepositoryImpl
import com.vlynn.data.repository.SearchRepositoryImpl
import com.vlynn.data.repository.SongRepositoryImpl
import com.vlynn.data.repository.StreamRepositoryImpl
import com.vlynn.data.repository.UpdateRepositoryImpl
import com.vlynn.domain.repository.AccountRepository
import com.vlynn.domain.repository.AlbumRepository
import com.vlynn.domain.repository.AnalyticsRepository
import com.vlynn.domain.repository.ArtistRepository
import com.vlynn.domain.repository.CommonRepository
import com.vlynn.domain.repository.HomeRepository
import com.vlynn.domain.repository.LocalPlaylistRepository
import com.vlynn.domain.repository.LyricsCanvasRepository
import com.vlynn.domain.repository.PlaylistRepository
import com.vlynn.domain.repository.PodcastRepository
import com.vlynn.domain.repository.SearchRepository
import com.vlynn.domain.repository.SongRepository
import com.vlynn.domain.repository.StreamRepository
import com.vlynn.domain.repository.UpdateRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule =
    module {
        single<AccountRepository>(createdAtStart = true) {
            AccountRepositoryImpl(get(), get())
        }

        single<AlbumRepository>(createdAtStart = true) {
            AlbumRepositoryImpl(get(), get())
        }

        single<ArtistRepository>(createdAtStart = true) {
            ArtistRepositoryImpl(get(), get())
        }

        single<CommonRepository>(createdAtStart = true) {
            CommonRepositoryImpl(get(named(SERVICE_SCOPE)), get(), get(), get(), get(), get()).apply {
                this.init("${fileDir()}/ytdlp-cookie.txt", get())
            }
        }

        single<HomeRepository>(createdAtStart = true) {
            HomeRepositoryImpl(get(), get())
        }

        single<LocalPlaylistRepository>(createdAtStart = true) {
            LocalPlaylistRepositoryImpl(get(), get())
        }

        single<LyricsCanvasRepository>(createdAtStart = true) {
            LyricsCanvasRepositoryImpl(get(), get(), get(), get(), get())
        }

        single<PlaylistRepository>(createdAtStart = true) {
            PlaylistRepositoryImpl(get(), get(), get())
        }

        single<PodcastRepository>(createdAtStart = true) {
            PodcastRepositoryImpl(get(), get())
        }

        single<SearchRepository>(createdAtStart = true) {
            SearchRepositoryImpl(get(), get())
        }

        single<SongRepository>(createdAtStart = true) {
            SongRepositoryImpl(get(), get(), get())
        }

        single<StreamRepository>(createdAtStart = true) {
            StreamRepositoryImpl(get(), get())
        }

        single<UpdateRepository>(createdAtStart = true) {
            UpdateRepositoryImpl(get())
        }

        single<AnalyticsRepository>(createdAtStart = true) {
            AnalyticsRepositoryImpl(get())
        }
    }