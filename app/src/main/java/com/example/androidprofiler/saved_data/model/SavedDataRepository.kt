package com.example.androidprofiler.saved_data.model

import com.example.androidprofiler.generate_data.model.local_data_source.LocalDao

class SavedDataRepository(private val localDao: LocalDao) {
    fun getAllTimes() = localDao.getAllTime()

    fun getCurrentData(currentDate: String) = localDao.getSelectedTimeData(currentDate)
}