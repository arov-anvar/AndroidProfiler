package com.example.androidprofiler.generate_data.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprofiler.generate_data.model.repository.GenerateDataRepository
import com.example.androidprofiler.generate_data.ui.AdapterItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class GenerateDataViewModel(private val repository: GenerateDataRepository) : ViewModel() {

    val rvData: MutableLiveData<List<AdapterItem>> = MutableLiveData()

    fun updateData() {
        val newData = repository.getCpuData()
        rvData.value = newData
    }

    fun saveBtnClicked() {
        runBlocking {
            repository.saveData(rvData.value ?: listOf())
        }
    }
}