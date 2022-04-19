package com.uuthman.movieapp.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uuthman.movieapp.presentation.destinations.DetailScreenDestination
import com.uuthman.movieapp.presentation.search.components.MovieItem
import com.uuthman.movieapp.presentation.search.components.SearchTextField
import com.uuthman.movieapp.ui.theme.LocalSpacing
import com.uuthman.movieapp.util.UiEvent

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Destination(start = true)
@Composable
fun SearchScreen(
    navigator: DestinationsNavigator,
    viewModel: SearchViewModel = hiltViewModel()
){
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = keyboardController){
        viewModel.uiEvent.collect{ event ->
            when(event){
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context = context)
                    )
                }
                else -> Unit
            }
        }
    }
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
                 viewModel.onEvent(SearchEvent.OnQueryChange(it))
            },
            shouldShowHint = state.isHintVisible,
            onSearch = {
                       keyboardController?.hide()
                viewModel.onEvent(SearchEvent.OnSearch)
            },
            modifier = Modifier.padding(horizontal = spacing.spaceMedium)
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.movies){ movie ->
                MovieItem(
                    movie.title,
                    movie.type,
                    movie.poster,
                    onClick = {
                        navigator.navigate(
                            DetailScreenDestination(id = movie.id)
                        )
                    },
                    modifier = Modifier
                        .padding(horizontal = spacing.spaceMedium)
                        .fillMaxWidth()
                        .height(170.dp)
                )
            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        when {
            state.isSearching -> CircularProgressIndicator()
            state.movies.isEmpty() -> {
                Text(
                    text = "No results",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}