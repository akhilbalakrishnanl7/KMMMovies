package com.litmus7.kmmmovies.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
 * MovieService which extends the Api abstract class. I has two suspend functions to retrieve movies from the tmdb
 */
internal class MovieService : Api() {

    /**
     * The fun getMovies(page:Int=1):MovieResponse retrieves all the movies from the popular endpoint. Here we are passing argument page as Integer to do
     * pagination and its default value is 1. Then we call the client.get method which is another suspend function and passing the pathUrl("") by passing
     * the endpoint and the passing the parameter("","") page. Then calls the body method to convert the response that we receive into the MovieResponse.
     */
    suspend fun getMovies(page: Int = 1): MovieResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()


    /**
     * The fun getMovie(movieId:Int):MovieRemote return a single movie when a movie id is passed. Then we call the client.get method which is another
     * suspend function and passing the pathUrl("") with movie id and then calls the body method to convert the response that we receive into the
     * MovieRemote.
     */
    suspend fun getMovie(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()

}