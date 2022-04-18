package com.uuthman.movieapp.presentation.search

sealed class SearchEvent {

    object OnSearch : SearchEvent()
    data class OnQueryChange(val query: String) : SearchEvent()
    data class OnMovieClicked(
        val id: String
    ) : SearchEvent()

}