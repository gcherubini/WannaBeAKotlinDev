package com.fittech.gcherubini.fittechandroid.network

import com.fittech.gcherubini.fittechandroid.model.network.output.GithubRepositoriesOutput
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("users/{user}/repos")
    fun getRepositories(@Path("user") user: String): Observable<GithubRepositoriesOutput>

    companion object {
        val HOST = "https://api.github.com/"

        fun create(): GithubApi {""
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(
                            RxJava2CallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory.create())
                    .baseUrl(HOST)
                    .build()

            return retrofit.create(GithubApi::class.java)
        }


    }
}