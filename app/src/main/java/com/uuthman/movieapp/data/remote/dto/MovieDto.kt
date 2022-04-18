package com.uuthman.movieapp.data.remote.dto

import com.squareup.moshi.Json

data class MovieDto(
    @field:Json(name = "Search")
    val search: List<Movie>,
    @field:Json(name = "Response")
    val successFul: String,
    @field:Json(name = "Error")
    val errorMessage: String? = ""
)