package com.litmus7.kmmmovies.domain.repository

import com.litmus7.kmmmovies.domain.model.Movie

/**
 * Defines a repository interface for movies and having two methods to retrieve movies by list and a single movie.
 */
internal interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie

}
