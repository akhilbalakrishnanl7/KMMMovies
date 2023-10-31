package com.litmus7.kmmmovies.data.remote

import com.litmus7.kmmmovies.util.Dispatcher
import kotlinx.coroutines.withContext

/**
 * The class RemoteDataSource accepts instances of class MovieService and Dispatcher and it is responsible for providing the remote data to the
 * repository as well as switching the network call to a different thread by using the dispatcher.
 */
internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {

    /**
     * The function suspend fun getMovies(page: Int) = withContext(dispatcher.io) is a suspending function that retrieves a list of movies from
     * the API service. The function takes a page number as an argument and returns a list of movies on that page. The function uses the
     * withContext() function to switch to the IO dispatcher before calling the apiService.getMovies(page) function. This ensures that the
     * network operation is performed on a background thread, so that the main thread is not blocked.
     * The withContext() function is also acts as a boundary between the IO dispatcher and the calling context. This means that any exceptions
     * that occur in the apiService.getMovies() function will not be propagated to the calling context.
     */
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        apiService.getMovies(page = page)
    }

    /**
     * This function retrieves a single movie from the API service.
     */
    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        apiService.getMovie(movieId = movieId)
    }

}
