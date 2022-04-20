package com.uuthman.movieapp.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uuthman.movieapp.domain.repository.MovieRepository
import com.uuthman.movieapp.domain.use_case.MovieUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val movieUseCases: MovieUseCases,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(DetailScreenState())
        private set

    init {
        viewModelScope.launch {
            val movieId = savedStateHandle.get<String>("id") ?: return@launch
            state = state.copy(isLoading = true)
            val result = movieUseCases.getMovieDetails(movieId)
            result.onSuccess {
                state = state.copy(
                    isLoading = false,
                    error = null,
                    movieDetails = it
                )
            }.onFailure {
                state = state.copy(
                    isLoading = false,
                    error = it.message,
                    movieDetails = null
                )
            }
        }
    }
}