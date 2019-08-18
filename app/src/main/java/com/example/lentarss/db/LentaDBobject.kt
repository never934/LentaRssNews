package com.example.lentarss.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LentaDBobject (
    @PrimaryKey
    val id: Long,
    val title: String
)