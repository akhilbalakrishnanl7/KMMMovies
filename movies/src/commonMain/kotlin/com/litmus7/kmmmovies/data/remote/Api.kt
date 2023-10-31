package com.litmus7.kmmmovies.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KEY = ""

/**
 * The abstract class Api provides the http client instance.
 */
internal abstract class Api {

    /**
     * Creates a new HttpClient instance with the ContentNegotiation plugin installed. The ContentNegotiation plugin allows the HttpClient to automatically
     * negotiate the content type of requests and responses with the server.
     * The json() function inside the ContentNegotiation block configures the HttpClient to use the kotlinx.serialization.json library to serialize and
     * deserialize JSON objects. The ignoreUnknownKeys and userAlternativeNames parameters control how the JSON serializer handles unknown keys and
     * alternative property names.
     */
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {

                /**
                 * ignoreUnknownKeys:
                 * if true, the JSON serializer will ignore any unknown keys in the JSON object.
                 * if false, the JSON serializer will throw an exception if it encounters an unknown key.
                 */
                ignoreUnknownKeys = true

                /**
                 * useAlternativeNames:
                 * if true, the JSON serializer will use the alternative names for properties that are defined in the @Serializable annotation.
                 * if false, the JSON serializer will use the property names exactly as they are written in the JSON object.
                 */
                useAlternativeNames = false
            })
        }
    }

    /**
     * The function HttpRequestBuilder.pathUrl(path:String) is an extension function on the HttpRequestBuilder class. It allows you to easily set the URL of
     * an HTTP request to the specified path, relative to the base URL. The function works by first calling the url() function on the HttpRequestBuilder
     * object. This function takes a lambda expression as an argument which is used to configure the URL of the request.
     *
     * Inside the lambda expression the takeFrom() function is used to set the protocol and host of the URL to the base URL. The path() function is then used
     * to append the specified path to the base URL. Finally, the parameter() function is used to add the api_key query parameter to the URL.
     */
    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", API_KEY)
        }
    }

}