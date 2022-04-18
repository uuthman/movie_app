package com.uuthman.movieapp.data.remote.dto

import com.squareup.moshi.Json

data class Movie(
    @field:Json(name = "Title")
    val title: String,
    @field:Json(name = "Year")
    val year: String,
    @field:Json(name = "imdbID")
    val id: String,
    @field:Json(name = "Type")
    val type: String,
    @field:Json(name = "Poster")
    val poster: String
)