package com.example.rondomquotegenerator.data.remote

import com.example.rondomquotegenerator.data.Model.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroConnection {


 private   val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())

        .build()

    val getApiCalls= retrofit.create(ApiCalls::class.java)
}