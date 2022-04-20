package com.uuthman.movieapp

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.SavedStateHandle
import coil.annotation.ExperimentalCoilApi
import com.google.common.truth.Truth.assertThat
import com.ramcosta.composedestinations.DestinationsNavHost
import com.uuthman.movieapp.data.repository.MovieRepositoryFake
import com.uuthman.movieapp.di.AppModule
import com.uuthman.movieapp.domain.di.MovieDomainModule
import com.uuthman.movieapp.domain.model.ItemDetails
import com.uuthman.movieapp.domain.model.MovieItem
import com.uuthman.movieapp.domain.use_case.MovieUseCases
import com.uuthman.movieapp.presentation.NavGraphs
import com.uuthman.movieapp.presentation.detail.DetailScreenViewModel
import com.uuthman.movieapp.presentation.search.SearchViewModel
import com.uuthman.movieapp.ui.theme.MovieAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@HiltAndroidTest
class MovieOverviewE2E {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

     private lateinit var repositoryFake: MovieRepositoryFake

    @Before
    fun setUp(){
        hiltRule.inject()

        composeRule.setContent {
            MovieAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }

    @Test
    fun searchMovie_andShowSearchedMovieList_andNavigateToSelectedMovieDetails(){

        composeRule
            .onNodeWithTag("search_textfield")
            .performTextInput("Batman")

        composeRule
            .onNodeWithContentDescription("Search")
            .performClick()



    }

}