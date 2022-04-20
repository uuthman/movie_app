package com.uuthman.movieapp.presentation.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uuthman.movieapp.domain.use_case.MovieUseCases
import com.uuthman.movieapp.util.UiEvent
import com.uuthman.movieapp.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases
) : ViewModel() {

    var state by mutableStateOf(SearchState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.OnSearch -> {
                executeSearch()
            }
            is SearchEvent.OnQueryChange -> {
                state = state.copy(query = event.query)
            }
            is SearchEvent.OnMovieClicked -> {

            }
        }
    }

    private fun executeSearch(){
        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                movies = emptyList()
            )
            movieUseCases
                .searchMovie(state.query)
                .onSuccess { movies ->
                    state = state.copy(
                        movies = movies,
                        isSearching = false,
                        query = ""
                    )
                }
                .onFailure {
                    state = state.copy(isSearching = false)
                    UiEvent.ShowSnackbar(
                        UiText.StringResource(it.message!!.toInt())
                    )
                }
        }
    }
}