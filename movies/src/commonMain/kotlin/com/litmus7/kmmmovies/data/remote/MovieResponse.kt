package com.litmus7.kmmmovies.data.remote

import kotlinx.serialization.Serializable

/**
 * Data class that holds the list of response from the api
 */
@Serializable
internal data class MovieResponse(
    val results: List<MovieRemote>
)
