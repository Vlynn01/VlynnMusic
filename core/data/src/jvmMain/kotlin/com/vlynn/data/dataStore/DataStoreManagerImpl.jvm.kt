package com.vlynn.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.vlynn.common.SETTINGS_FILENAME
import com.vlynn.data.io.getHomeFolderPath
import createDataStore
import java.io.File

actual fun createDataStoreInstance(): DataStore<Preferences> = createDataStore(
    producePath = {
        val file = File(getHomeFolderPath(listOf(".vlynnmusic")), "$SETTINGS_FILENAME.preferences_pb")
        file.absolutePath
    }
)