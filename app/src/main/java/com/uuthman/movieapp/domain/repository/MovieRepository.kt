package com.uuthman.movieapp.domain.repository

import com.uuthman.movieapp.domain.model.MovieItem

interface MovieRepository {
    suspend fun searchMovie(
        query: String
    ): Result<List<MovieItem>>
}