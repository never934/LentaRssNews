package com.example.lentarss.db

import androidx.room.RoomDatabase
import androidx.room.Database

@Database(entities = [LentaDBobject::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lentaDao(): LentaDBcontroller
}