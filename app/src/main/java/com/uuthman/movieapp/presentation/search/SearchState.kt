package com.uuthman.movieapp.presentation.search

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false
)