package com.example.androidprofiler.saved_data.selected_data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.androidprofiler.saved_data.model.SavedDataRepository

class SelectedDataViewModel(private val repository: SavedDataRepository, private val currentTime: String) : ViewModel() {

    val currentData by lazy {
        return@lazy repository.getCurrentData(currentTime).map {
            val list = mutableListOf<String>()
            it.apply {
                list.add("time: $time")
                list.add("cpuName: $cpuName")
                list.add("numberOfCores: $numberOfCores")
                list.add("currentFrequenciesCpu1: $currentFrequenciesCpu1")
                list.add("currentFrequenciesCpu2: $currentFrequenciesCpu2")
                list.add("currentFrequenciesCpu3: $currentFrequenciesCpu3")
                list.add("currentFrequenciesCpu4: $currentFrequenciesCpu4")
                list.add("currentFrequenciesCpu5: $currentFrequenciesCpu5")
                list.add("currentFrequenciesCpu6: $currentFrequenciesCpu6")
                list.add("currentFrequenciesCpu7: $currentFrequenciesCpu7")
                list.add("currentFrequenciesCpu8: $currentFrequenciesCpu8")
                list.add("l1Chaces: $l1Chaces")
                list.add("l2Chaces: $l2Chaces")
                list.add("l3Chaces: $l3Chaces")
                list.add("l4Chaces: $l4Chaces")
                list.add("buildVersion: $buildVersion")
                list.add("sdk: $sdk")
                list.add("codeName: $codeName")
                list.add("brand: $brand")
                list.add("model: $model")
                list.add("manufacturer: $manufacturer")
                list.add("vm: $vm")
                list.add("kernel: $kernel")
                list.add("nativeHeapSize: $nativeHeapSize")
                list.add("nativeHeapFreeSize: $nativeHeapFreeSize")
                list.add("usedMemInBytes: $usedMemInBytes")
                list.add("usedMemInPercentage: $usedMemInPercentage")
            }
            list
        }
    }
}