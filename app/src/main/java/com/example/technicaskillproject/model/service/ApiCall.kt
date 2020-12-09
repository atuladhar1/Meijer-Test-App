package com.example.technicaskillproject.model.service

import com.example.technicaskillproject.model.Data
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//Interface for Retrofit to make APICall
interface ApiCall {
    @GET("anime/")
    fun getDataFromAPI(@Query("q") animeName: String): Single<Data>

    companion object {
        operator fun invoke(): ApiCall {
            return Retrofit.Builder().baseUrl("https://api.jikan.moe/v3/search/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCall::class.java)
        }
    }
}