package com.uuthman.movieapp.presentation.detail

import com.uuthman.movieapp.domain.model.ItemDetails

data class DetailScreenState(
    val isLoading: Boolean = false,
    val movieDetails: ItemDetails? = null,
    val error: String? = null
)
