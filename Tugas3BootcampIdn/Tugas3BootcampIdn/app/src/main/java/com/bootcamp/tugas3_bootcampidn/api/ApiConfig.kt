package com.bootcamp.tugas3_bootcampidn.api

import ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//objek retrofit client
object ApiConfig {
    private const val baseUrl = "https://newsapi.org/v2/"

    private fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() : ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}