package com.uuthman.movieapp.data.repository

import com.google.common.truth.Truth.assertThat
import com.uuthman.movieapp.data.remote.*
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class MovieRepositoryImplTest {

    private lateinit var repository: MovieRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: MovieApi


    @Before
    fun setUp(){
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1,TimeUnit.SECONDS)
            .readTimeout(1,TimeUnit.SECONDS)
            .connectTimeout(1,TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(MovieApi::class.java)
        repository = MovieRepositoryImpl(
            api = api
        )
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `Search for movie and return a valid response`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validSearchMovieResponse)
        )

        val result = repository.searchMovie("Batman Begins")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search for movie and return an invalid response`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(invalidSearchMovieResponse)
        )

        val result = repository.searchMovie("Batman Begins")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Return search movie details as success`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validMovieDetailResponse)
        )

        val result = repository.getItemDetail("tt0372784")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Return search movie details as failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(invalidMovieDetailResponse)
        )

        val result = repository.getItemDetail("tt0372784")

        assertThat(result.isFailure).isTrue()
    }
}