package com.uuthman.movieapp.data.remote.dto

import com.squareup.moshi.Json

data class MovieDetailDto(

    @field:Json(name = "Title")
    val title: String,
    @field:Json(name = "Released")
    val releasedDate: String,
    @field:Json(name = "Genre")
    val genre: String,
    @field:Json(name = "Runtime")
    val time: String,
    @field:Json(name = "Language")
    val language: String,
    @field:Json(name = "Rated")
    val rated: String,
    @field:Json(name = "Poster")
    val poster: String,
    @field:Json(name = "Response")
    val successFul: String,
    @field:Json(name = "Error")
    val errorMessage: String? = ""
)
