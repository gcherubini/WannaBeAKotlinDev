package com.gcherubini.wannabeakotlindev.network

import com.gcherubini.wannabeakotlindev.model.GithubRepository
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Observable<List<GithubRepository>>

    companion object {
        val HOST = "https://api.github.com/"

        fun create(): GithubApi {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .baseUrl(HOST)
                    .build()

            return retrofit.create(GithubApi::class.java)
        }


    }
}