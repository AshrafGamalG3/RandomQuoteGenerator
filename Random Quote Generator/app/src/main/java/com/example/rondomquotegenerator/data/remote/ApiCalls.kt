package com.example.rondomquotegenerator.data.remote


import com.example.rondomquotegenerator.data.Model.QuoteModelItem
import retrofit2.http.GET

interface ApiCalls {


    @GET("random")
    suspend fun getQuote():List<QuoteModelItem>
}