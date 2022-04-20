package com.uuthman.movieapp

import com.uuthman.movieapp.data.repository.MovieRepositoryFake
import com.uuthman.movieapp.di.AppModule
import com.uuthman.movieapp.domain.di.MovieDomainModule
import com.uuthman.movieapp.domain.repository.MovieRepository
import com.uuthman.movieapp.domain.use_case.GetMovieDetails
import com.uuthman.movieapp.domain.use_case.MovieUseCases
import com.uuthman.movieapp.domain.use_case.SearchMovie
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(components = [SingletonComponent::class,ViewModelComponent::class], replaces = [AppModule::class, MovieDomainModule::class])
object FakeAppModule {

    @Provides
    fun provideMovieRepository(): MovieRepository{
        return MovieRepositoryFake()
    }

    @Provides
    fun provideMovieUseCases(repository: MovieRepository): MovieUseCases{
        return MovieUseCases(
            searchMovie = SearchMovie(repository = repository),
            getMovieDetails = GetMovieDetails(repository = repository)
        )
    }
}