package com.vlynn.data.io

import com.vlynn.data.db.documentDirectory
import okio.FileSystem

actual fun fileSystem(): FileSystem = FileSystem.SYSTEM
actual fun fileDir(): String = documentDirectory() + "/VlynnMusic"