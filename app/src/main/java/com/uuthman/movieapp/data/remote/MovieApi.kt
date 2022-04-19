package com.uuthman.movieapp.data.remote

import com.uuthman.movieapp.data.remote.dto.MovieDetailDto
import com.uuthman.movieapp.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET(".")
    suspend fun searchMovie(
        @Query("s") searchName: String,
    ): MovieDto

    @GET(".")
    suspend fun movieDetails(
        @Query("i") id: String
    ): MovieDetailDto

    companion object{
        const val BASE_URL = "https://www.omdbapi.com/"
    }
}