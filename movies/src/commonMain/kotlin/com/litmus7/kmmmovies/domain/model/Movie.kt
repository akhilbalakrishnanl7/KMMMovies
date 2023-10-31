package com.litmus7.kmmmovies.domain.model

/**
 * This data class represents a movie. This is a special type of class that is optimized for storing data. Like the MovieRemote class
 * this class don't have any annotations and will not related to any sort of manipulation. We will use this data class in our UI
 * instead of MovieRemote.
 */
data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val releaseDate: String
)
