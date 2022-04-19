package com.uuthman.movieapp.domain.use_case

import com.uuthman.movieapp.domain.model.ItemDetails
import com.uuthman.movieapp.domain.repository.MovieRepository
import com.uuthman.movieapp.util.toThrowable

class GetMovieDetails(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(id: String): Result<ItemDetails>{
        if(id.isBlank()){
            return Result.failure(toThrowable("No id seen"))
        }

        return repository.getItemDetail(id)
    }
}