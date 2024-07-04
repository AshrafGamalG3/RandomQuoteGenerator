package com.example.rondomquotegenerator.ui

import android.util.Log
import com.example.rondomquotegenerator.data.Model.QuoteModelItem
import com.example.rondomquotegenerator.data.local.MyDatabase
import com.example.rondomquotegenerator.data.remote.RetroConnection

class Repo {

    suspend fun getQuote(): List<QuoteModelItem> {
        return try {
            val data = getQuoteRemote()
            cacheQuote(data)
            data
        } catch (e: Exception) {
            getQuoteLocal() ?: emptyList()
        }
    }

  private  suspend fun getQuoteRemote(): List<QuoteModelItem> {
        return try {
            Log.e("TAG", "getQuoteRemote: api  success ", )
            RetroConnection.getApiCalls.getQuote()

        } catch (e: Exception) {
            Log.e("TAG", "getQuoteRemote: api fail  ", )
            throw e
        }
    }

  private   fun getQuoteLocal(): List<QuoteModelItem>? {
      Log.e("TAG", "getQuoteRemote: room success get ", )
        return MyDatabase.myDatabase?.getMyDao()?.getQuote()
    }

 private    fun cacheQuote(list: List<QuoteModelItem>) {
     Log.e("TAG", "getQuoteRemote: room success insert ", )
        MyDatabase.myDatabase?.getMyDao()?.insertQuote(list)
    }
}
