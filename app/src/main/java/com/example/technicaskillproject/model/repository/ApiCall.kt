package com.example.technicaskillproject.model.repository

import com.example.technicaskillproject.model.Data
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {
    @GET("anime/")
    fun getDataFromAPI(@Query("q") animeName: String): Single<Data>
}