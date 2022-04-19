package com.uuthman.movieapp.domain.repository

import com.uuthman.movieapp.domain.model.ItemDetails
import com.uuthman.movieapp.domain.model.MovieItem

interface MovieRepository {
    suspend fun searchMovie(
        query: String
    ): Result<List<MovieItem>>

    suspend fun getItemDetail(
        id: String
    ): Result<ItemDetails>
}