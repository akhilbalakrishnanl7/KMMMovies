package com.litmus7.kmmmovies.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This is a data class called MovieRemote that is annotated with @Serializable. This means that the class can be serialized and
 * deserialized using the kotlin serialization library.
 *
 * The @SerialName annotation is used to change the name of the property that is used in the serialized representation of the object.
 * Here the poster_path property in the JSON response will be mapped to the posterImage property in the Kotlin object. It represents
 * the movie data.
 */
@Serializable
internal data class MovieRemote(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterImage: String,
    @SerialName("release_date")
    val releaseDate: String
)
