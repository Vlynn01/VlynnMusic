package com.vlynn.data.di.loader

import com.vlynnmusic.media_jvm.di.loadVlcModule

actual fun loadMediaService() {
    loadVlcModule()
}
