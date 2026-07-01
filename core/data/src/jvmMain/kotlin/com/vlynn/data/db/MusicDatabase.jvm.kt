package com.vlynn.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.vlynn.common.DB_NAME
import com.vlynn.data.io.getHomeFolderPath
import java.io.File

actual fun getDatabaseBuilder(
    converters: Converters
): RoomDatabase.Builder<MusicDatabase> {
    return Room.databaseBuilder<MusicDatabase>(
        name = getDatabasePath()
    ).addTypeConverter(converters)
}

actual fun getDatabasePath(): String {
    val dbFile = File(getHomeFolderPath(listOf(".vlynnmusic", "db")), DB_NAME)
    return dbFile.absolutePath
}