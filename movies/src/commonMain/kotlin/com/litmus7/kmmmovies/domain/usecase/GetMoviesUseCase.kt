package com.litmus7.kmmmovies.domain.usecase

import com.litmus7.kmmmovies.domain.model.Movie
import com.litmus7.kmmmovies.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * The class GetMoviesUseCase : KoinComponent defines a use case for retrieving movies. The class inherits from the KoinComponent interface.
 * This means that the class use the koin dependency injection library to inject the MovieRepository dependency.
 */
class GetMoviesUseCase : KoinComponent {

    private val repository: MovieRepository by inject()

    /**
     * This method is the entry point for the use case. It takes a page number as input and returns a list of movies on that page.
     *
     * The @Throws(Exception::class) annotation indicates that the method can throw an exception. This is necessary because the
     * MovieRepository dependency could throw an exception if it is unable to retrieve movie data. The annotation will also be
     * helpful for iOS in a kotlin multiplatform project because when kotlin code is compiled to Objective-C, all exceptions are
     * converted to NSError objects.This means that the iOS developer can catch any exception that is thrown by the kotlin code
     * by simply catching NSError objects.
     *
     * However, the NSError object does not contain any information about the original exception that was thrown by kotlin code.
     * The annotation allows the kotlin developers to provide the iOS developer with information about the original exception.
     *
     * The operator fun invoke() method is a special method that allows the use case to be invoked like a function. This makes it
     * easy to use the use case in other parts of the application.
     */
    @Throws(Exception::class)
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovies(page = page)
    }

}