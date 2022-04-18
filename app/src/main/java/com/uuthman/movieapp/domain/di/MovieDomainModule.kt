package com.uuthman.movieapp.domain.di

import com.uuthman.movieapp.domain.repository.MovieRepository
import com.uuthman.movieapp.domain.use_case.MovieUseCases
import com.uuthman.movieapp.domain.use_case.SearchMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MovieDomainModule {

    @ViewModelScoped
    @Provides
    fun provideMovieUseCases(
        repository: MovieRepository,
    ): MovieUseCases{
        return MovieUseCases(
            searchMovie = SearchMovie(repository = repository)
        )
    }
}