package com.uuthman.movieapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class KeyAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request
            .url
            .newBuilder()
            .addQueryParameter("apiKey","43ac6862")
            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request = request)
    }
}