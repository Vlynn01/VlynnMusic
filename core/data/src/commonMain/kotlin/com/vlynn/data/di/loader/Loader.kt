package com.vlynn.data.di.loader

import com.vlynn.data.di.databaseModule
import com.vlynn.data.di.mediaHandlerModule
import com.vlynn.data.di.repositoryModule
import org.koin.core.context.loadKoinModules

fun loadAllModules() {
    loadKoinModules(
        listOf(
            databaseModule,
            repositoryModule,
        ),
    )
    loadKoinModules(mediaHandlerModule)
    loadMediaService()
}

expect fun loadMediaService()