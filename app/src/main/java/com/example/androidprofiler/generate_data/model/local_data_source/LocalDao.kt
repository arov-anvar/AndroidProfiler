package com.example.androidprofiler.generate_data.model.local_data_source

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDao {

    @Query("SELECT result_entity.time FROM result_entity")
    fun getAllTime(): LiveData<List<String>>

    @Query("SELECT * FROM result_entity WHERE :selectedTime = result_entity.time")
    fun getSelectedTimeData(selectedTime: String): LiveData<LocalEntity>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(localEntity: LocalEntity)
}