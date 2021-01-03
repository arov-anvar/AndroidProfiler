package com.example.androidprofiler.saved_data

import androidx.fragment.app.Fragment
import com.example.androidprofiler.AndroidProfilerApp
import com.example.androidprofiler.saved_data.model.SavedDataRepository

class SavedDataBuilder {
    fun build(fragment: Fragment): SavedDataViewModel {
        val localDao = (fragment.activity?.application as AndroidProfilerApp).database.localDao()
        val repository = SavedDataRepository(localDao)
        return SavedDataViewModel(repository)
    }
}