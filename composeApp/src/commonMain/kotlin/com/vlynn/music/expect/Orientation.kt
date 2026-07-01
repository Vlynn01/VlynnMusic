package com.vlynn.music.expect

enum class Orientation {
    PORTRAIT, LANDSCAPE, UNSPECIFIED
}

expect fun currentOrientation(): Orientation