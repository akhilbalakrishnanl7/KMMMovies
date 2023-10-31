package com.litmus7.kmmmovies.domain.usecase

import com.litmus7.kmmmovies.domain.model.Movie
import com.litmus7.kmmmovies.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


/**
 * The class GetMovieUseCase : KoinComponent defines a use case for retrieving a single movie. The class inherits from the KoinComponent interface.
 * This means that the class use the koin dependency injection library to inject the MovieRepository dependency.
 */
class GetMovieUseCase : KoinComponent {

    private val repository: MovieRepository by inject()

    /**
     * This method is the entry point for the use case. It takes a movie id as input and return the movie.
     * The @Throws(Exception::class) annotation indicates that the method can throw an exception. This is necessary because the
     * MovieRepository dependency could throw an exception if it is unable to retrieve movie data.
     * The operator fun invoke() method is a special method that allows the use case to be invoked like a function. This makes it
     * easy to use the use case in other parts of the application.
     */
    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }

}