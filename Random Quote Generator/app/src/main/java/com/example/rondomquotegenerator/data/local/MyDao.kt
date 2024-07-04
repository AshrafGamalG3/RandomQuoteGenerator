package com.example.rondomquotegenerator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.rondomquotegenerator.data.Model.QuoteModelItem
import retrofit2.http.GET

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertQuote(arrayList: List<QuoteModelItem>)

    @Query("select * from QuoteModelItem ORDER BY RANDOM() LIMIT 1 ")
    fun getQuote():List<QuoteModelItem>


}