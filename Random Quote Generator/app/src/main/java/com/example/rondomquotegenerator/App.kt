package com.example.rondomquotegenerator

import android.app.Application
import com.example.rondomquotegenerator.data.local.MyDatabase

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        MyDatabase.getInstance(this)

    }
}