package com.example.rondomquotegenerator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.rondomquotegenerator.data.Model.QuoteModelItem

@Database(entities = [QuoteModelItem::class], version = 1)
abstract class   MyDatabase :RoomDatabase(){

    abstract fun getMyDao():MyDao

    companion object{


         var myDatabase:MyDatabase?=null

        fun getInstance(context: Context){
           myDatabase =Room.databaseBuilder(context.applicationContext,MyDatabase::class.java,"quote_db")
                .fallbackToDestructiveMigration()
                    .build()

        }


    }

}