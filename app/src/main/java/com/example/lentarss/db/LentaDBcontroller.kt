package com.example.lentarss.db

import androidx.room.*

@Dao
interface LentaDBcontroller {
    @Query("SELECT * FROM lentadbobject")
    fun getAll(): List<LentaDBobject>

    @Insert
    fun insert(lentaObject: LentaDBobject)

    @Update
    fun update(lentaObject: LentaDBobject)

    @Delete
    fun delete(lentaObject: LentaDBobject)
}