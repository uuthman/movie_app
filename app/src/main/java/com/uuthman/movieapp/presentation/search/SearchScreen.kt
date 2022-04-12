package com.uuthman.movieapp.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.uuthman.movieapp.presentation.search.components.SearchTextField
import com.uuthman.movieapp.ui.theme.LocalSpacing

@Destination(start = true)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ){
        Text(
            text = "Movie",
            modifier = Modifier.padding(start = spacing.spaceMedium, top = spacing.spaceSmall),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        SearchTextField(
            text = state.query,
            onValueChange = {

            },
            shouldShowHint = state.isHintVisible,
            onSearch = {

            },
            modifier = Modifier.padding(horizontal = spacing.spaceMedium)
        )
    }
}