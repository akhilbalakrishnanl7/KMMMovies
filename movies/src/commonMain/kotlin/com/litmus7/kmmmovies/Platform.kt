package com.litmus7.kmmmovies

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform