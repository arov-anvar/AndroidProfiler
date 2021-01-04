package com.example.androidprofiler.generate_data.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprofiler.generate_data.model.repository.GenerateDataRepository
import kotlinx.coroutines.launch

class GenerateDataViewModel(private val repository: GenerateDataRepository) : ViewModel() {

    val rvData: MutableLiveData<List<AdapterItem>> = MutableLiveData()

    fun updateData() {
        val newData = repository.getData()
        rvData.value = newData
    }

    fun saveBtnClicked() {
        viewModelScope.launch {
            repository.saveData(rvData.value ?: listOf())
        }
    }
}