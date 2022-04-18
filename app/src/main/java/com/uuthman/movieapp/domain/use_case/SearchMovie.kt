package com.uuthman.movieapp.domain.use_case

import com.uuthman.movieapp.domain.model.MovieItem
import com.uuthman.movieapp.domain.repository.MovieRepository

class SearchMovie(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(
        query: String
    ): Result<List<MovieItem>>{

        if(query.isBlank()){
            return Result.success(emptyList())
        }

        return  repository.searchMovie(
            query = query.trim()
        )
    }
}