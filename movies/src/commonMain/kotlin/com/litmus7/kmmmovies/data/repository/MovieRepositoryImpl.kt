package com.litmus7.kmmmovies.data.repository

import com.litmus7.kmmmovies.data.remote.RemoteDataSource
import com.litmus7.kmmmovies.data.util.toMovie
import com.litmus7.kmmmovies.domain.model.Movie
import com.litmus7.kmmmovies.domain.repository.MovieRepository

/**
 * Implementation of MovieRepository. The class takes an RemoteDataSource object as input and uses it to retrieve movie data from a
 * remote server. It implements the two methods of MovieRepository.
 */
internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {

    /**
     * These methods overrides the getMovies() and getMovie() method of MovieRepository and retrieves a list of movies and a single
     * movie respectively from the remote and converts it to a Movie object.
     */
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}
