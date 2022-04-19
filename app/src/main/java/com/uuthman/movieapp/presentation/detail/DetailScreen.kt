package com.uuthman.movieapp.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.ramcosta.composedestinations.annotation.Destination
import com.uuthman.movieapp.presentation.detail.components.DetailCard
import com.uuthman.movieapp.presentation.detail.components.DetailHeader
import com.uuthman.movieapp.ui.theme.LocalSpacing



@OptIn(ExperimentalCoilApi::class)
@Destination
@Composable
fun DetailScreen(
    id: String,
    viewModel: DetailScreenViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current

    val state = viewModel.state

    if(state.error == null){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
        ){
            item {
                state.movieDetails?.let {
                    DetailHeader(
                        title = it.title,
                        image = it.image,
                        genre = it.genre
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    DetailCard(
                        language = it.language,
                        time = it.time,
                        rated = it.rated
                    )
                }

            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        if(state.isLoading) {
            CircularProgressIndicator()
        } else if(state.error != null) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error
            )
        }
    }

}