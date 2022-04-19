package com.uuthman.movieapp.data.mapper

import com.uuthman.movieapp.data.remote.dto.MovieDetailDto
import com.uuthman.movieapp.domain.model.ItemDetails

fun MovieDetailDto.toItemDetail(): ItemDetails{
    return ItemDetails(
        title = title,
        releasedDate = releasedDate,
        genre = genre,
        time = time,
        language = language,
        rated = rated,
        image = poster
    )
}