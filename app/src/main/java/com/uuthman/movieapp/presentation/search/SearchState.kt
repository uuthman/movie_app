package com.uuthman.movieapp.presentation.search

import com.uuthman.movieapp.domain.model.MovieItem

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val movies: List<MovieItem> = emptyList()
)