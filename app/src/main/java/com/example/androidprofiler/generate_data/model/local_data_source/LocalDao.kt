package com.example.androidprofiler.generate_data.model.local_data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDao {

    @Query("SELECT * FROM result_entity")
    suspend fun getAllData(): List<LocalEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(localEntity: LocalEntity)
}