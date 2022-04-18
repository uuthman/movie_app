package com.uuthman.movieapp.data.remote

import com.uuthman.movieapp.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    suspend fun searchMovie(
        @Query("s") searchName: String,
    ): MovieDto

    companion object{
        const val BASE_URL = "https://www.omdbapi.com/"
    }
}