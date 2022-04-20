package com.uuthman.movieapp.data.repository

import com.uuthman.movieapp.domain.model.ItemDetails
import com.uuthman.movieapp.domain.model.MovieItem
import com.uuthman.movieapp.domain.repository.MovieRepository


class MovieRepositoryFake : MovieRepository {

    var shouldReturnError = false

    private var searchMovieItemResults = listOf(
        MovieItem(
            title = "Batman",
            year = "2010",
            id = "1234",
            type = "movie",
            poster = ""
        )
    )
    var movieDetailResults: ItemDetails? = null

    override suspend fun searchMovie(query: String): Result<List<MovieItem>> {
        return if(shouldReturnError){
            Result.failure(Throwable())
        }else{
            Result.success(searchMovieItemResults)
        }
    }

    override suspend fun getItemDetail(id: String): Result<ItemDetails> {
        return if(shouldReturnError){
            Result.failure(Throwable())
        }else{
            Result.success(movieDetailResults!!)
        }
    }
}