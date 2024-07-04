package com.example.rondomquotegenerator.data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteModelItem(
    @PrimaryKey
    val a: String,
    val h: String,
    val q: String
)