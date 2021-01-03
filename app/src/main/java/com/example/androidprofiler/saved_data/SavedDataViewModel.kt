package com.example.androidprofiler.saved_data

import androidx.lifecycle.ViewModel
import com.example.androidprofiler.saved_data.model.SavedDataRepository

class SavedDataViewModel(private val repository: SavedDataRepository) : ViewModel() {

    val rvData by lazy {
        return@lazy repository.getAllTimes()
    }
}