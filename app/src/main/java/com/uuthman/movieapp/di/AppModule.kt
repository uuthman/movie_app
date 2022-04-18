package com.uuthman.movieapp.di

import com.uuthman.movieapp.data.remote.KeyAuthInterceptor
import com.uuthman.movieapp.data.remote.MovieApi
import com.uuthman.movieapp.data.repository.MovieRepositoryImpl
import com.uuthman.movieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideKeyInterceptor() = KeyAuthInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(keyAuthInterceptor: KeyAuthInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(keyAuthInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providerMovieApi(client: OkHttpClient): MovieApi{
        return Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        api: MovieApi
    ): MovieRepository{
        return MovieRepositoryImpl(
            api = api
        )
    }
}