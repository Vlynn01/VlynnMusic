package com.vlynn.data.di

import DatabaseDao
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.vlynn.data.dataStore.DataStoreManagerImpl
import com.vlynn.data.dataStore.createDataStoreInstance
import com.vlynn.data.db.Converters
import com.vlynn.data.db.MusicDatabase
import com.vlynn.data.db.datasource.AnalyticsDatasource
import com.vlynn.data.db.datasource.LocalDataSource
import com.vlynn.data.db.getDatabaseBuilder
import com.vlynn.domain.manager.DataStoreManager
import com.vlynn.kotlinytmusicscraper.YouTube
import com.vlynn.spotify.Spotify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import org.simpmusic.aiservice.AiClient
import org.simpmusic.lyrics.VlynnMusicLyricsClient
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
val databaseModule =
    module {
        single(createdAtStart = true) {
            Converters()
        }
        // Database
        single(createdAtStart = true) {
            getDatabaseBuilder(
                get<Converters>()
            )
                .setDriver(BundledSQLiteDriver())
                .setQueryCoroutineContext(Dispatchers.IO)
                .build()
        }
        // DatabaseDao
        single(createdAtStart = true) {
            get<MusicDatabase>().getDatabaseDao()
        }
        // LocalDataSource
        single(createdAtStart = true) {
            LocalDataSource(get<DatabaseDao>())
        }
        // AnalyticsDatasource
        single(createdAtStart = true) {
            AnalyticsDatasource(get<DatabaseDao>())
        }
        // Datastore
        single(createdAtStart = true) {
            createDataStoreInstance()
        }
        // DatastoreManager
        single<DataStoreManager>(createdAtStart = true) {
            DataStoreManagerImpl(get<DataStore<Preferences>>())
        }

        // Move YouTube from Singleton to Koin DI
        single(createdAtStart = true) {
            YouTube()
        }

        single(createdAtStart = true) {
            Spotify()
        }

        single(createdAtStart = true) {
            AiClient()
        }

        single(createdAtStart = true) {
            VlynnMusicLyricsClient()
        }
    }