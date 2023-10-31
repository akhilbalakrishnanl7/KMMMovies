package com.litmus7.kmmmovies.di

import com.litmus7.kmmmovies.data.remote.MovieService
import com.litmus7.kmmmovies.data.remote.RemoteDataSource
import com.litmus7.kmmmovies.data.repository.MovieRepositoryImpl
import com.litmus7.kmmmovies.domain.repository.MovieRepository
import com.litmus7.kmmmovies.domain.usecase.GetMovieUseCase
import com.litmus7.kmmmovies.domain.usecase.GetMoviesUseCase
import com.litmus7.kmmmovies.util.provideDispatcher
import org.koin.dsl.module

/**
 * This code is useful for sharing Koin modules across different parts of a Kotlin Multiplatform project. For example, the dataModule and
 * utilityModule could be shared between the iOS and Android parts of the project, while the domainModule could be specific to the Android
 * part of the project. To use the shared Koin modules, you would simply need to call the getSharedModules() function from each part of the project.
 */

// dataModule: This module provides the RemoteDataSource and MovieService dependencies.
private val dataModule = module {
    factory {
        RemoteDataSource(get(), get())
    }
    factory {
        MovieService()
    }
}

// utilityModule: This module provides the provideDispatcher() function, which is used to create a dispatcher for coroutines.
private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

// domainModule: This module provides the MovieRepositoryImpl class, which implements the MovieRepository interface, and the
// GetMoviesUseCase and GetMovieUseCase classes, which are use cases for retrieving movies.
private val domainModule = module {
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
    factory {
        GetMoviesUseCase()
    }
    factory {
        GetMovieUseCase()
    }
}

// The listOf(dataModule, utilityModule, domainModule) code creates a list of the three Koin modules.
private val sharedModules = listOf(dataModule, utilityModule, domainModule)

// The getSharedModules() function simply returns the list of Koin modules.
fun getSharedModules() = sharedModules