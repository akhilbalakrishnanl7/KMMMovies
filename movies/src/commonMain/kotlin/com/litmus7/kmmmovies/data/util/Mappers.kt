package com.litmus7.kmmmovies.data.util

import com.litmus7.kmmmovies.data.remote.MovieRemote
import com.litmus7.kmmmovies.domain.model.Movie

/**
 * Mappers are used to pass data from the one layer to another.
 * The function internal fun MovieRemote.toMovie():Movie is an extension function to map the data from the data layer to the domain layer.
 * The function takes MovieRemote object as input and returns a Movie object as output.
 */
internal fun MovieRemote.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = createImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

/**
 * It will create a complete image url by appending the posterImage to the base URL (https://image.tmdb.org/t/p/w500/) of tmdb image server.
 */
private fun createImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/${posterImage}"
