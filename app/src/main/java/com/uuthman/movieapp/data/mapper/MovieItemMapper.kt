package com.uuthman.movieapp.data.mapper

import com.uuthman.movieapp.data.remote.dto.Movie
import com.uuthman.movieapp.domain.model.MovieItem

fun Movie.toMovieItem(): MovieItem{
    return MovieItem(
        title = title,
        year = year,
        id = id,
        type = type,
        poster = poster
    )
}