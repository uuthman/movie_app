package com.uuthman.movieapp.data.repository

import com.uuthman.movieapp.data.mapper.toItemDetail
import com.uuthman.movieapp.data.mapper.toMovieItem
import com.uuthman.movieapp.data.remote.MovieApi
import com.uuthman.movieapp.domain.model.ItemDetails
import com.uuthman.movieapp.domain.model.MovieItem
import com.uuthman.movieapp.domain.repository.MovieRepository
import com.uuthman.movieapp.util.Constants.IS_SUCCESSFUL
import com.uuthman.movieapp.util.toThrowable

class MovieRepositoryImpl(
    private val api: MovieApi
): MovieRepository {

    override suspend fun searchMovie(query: String): Result<List<MovieItem>> {
        return try {
            val response = api.searchMovie(
                query
            )
            if(response.successFul == IS_SUCCESSFUL){
                Result.success(
                    response.search.map {
                        it.toMovieItem()
                    }
                )
            }else{
                val error = response.errorMessage
                Result.failure(toThrowable(error!!))
            }

        }catch (e: Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getItemDetail(id: String): Result<ItemDetails> {
        return try {
            val response = api.movieDetails(id)
            if(response.successFul == IS_SUCCESSFUL){
                Result.success(
                    response.toItemDetail()
                )
            }else{
                val error = response.errorMessage
                Result.failure(toThrowable(error!!))
            }
        }catch (e: Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }
}