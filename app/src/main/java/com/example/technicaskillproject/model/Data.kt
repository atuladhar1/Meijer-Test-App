package com.example.technicaskillproject.model

import java.io.Serializable

data class Data(
    val last_page: Int,
    val request_cache_expiry: Int,
    val request_cached: Boolean,
    val request_hash: String,
    val results: ArrayList<Result>
)

data class Result(
    val airing: Boolean,
    val end_date: String,
    val episodes: Int,
    val image_url: String,
    val mal_id: Int,
    val members: Int,
    val rated: String,
    val score: Double,
    val start_date: String,
    val synopsis: String,
    val title: String,
    val type: String,
    val url: String
) : Serializable