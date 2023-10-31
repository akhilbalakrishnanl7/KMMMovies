package com.litmus7.kmmmovies.data.remote

import kotlinx.serialization.Serializable

/**
 * This is a data class called MovieResponse that is annotated with @Serializable. This means that the class can be serialized and
 * deserialized using the kotlin serialization library.
 * Represents a response from a remote server that retrieves a list of movies.
 */
@Serializable
internal data class MovieResponse(
    val results: List<MovieRemote>
)
