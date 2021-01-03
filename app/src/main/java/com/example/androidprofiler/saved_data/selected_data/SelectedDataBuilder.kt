package com.example.androidprofiler.saved_data.selected_data

import androidx.fragment.app.Fragment
import com.example.androidprofiler.AndroidProfilerApp
import com.example.androidprofiler.saved_data.model.SavedDataRepository

class SelectedDataBuilder {
    fun build(fragment: Fragment, currentTime: String): SelectedDataViewModel {
        val localDao = (fragment.activity?.application as AndroidProfilerApp).database.localDao()
        val repository = SavedDataRepository(localDao)
        return SelectedDataViewModel(repository, currentTime)
    }
}