package com.example.androidprofiler.saved_data.model

import androidx.lifecycle.map
import com.example.androidprofiler.decrypt
import com.example.androidprofiler.encrypt
import com.example.androidprofiler.generate_data.model.local_data_source.LocalDao
import com.example.androidprofiler.generate_data.model.local_data_source.LocalEntity

class SavedDataRepository(private val localDao: LocalDao) {
    fun getAllTimes() = localDao.getAllTime().map { list ->
        list.map {
            it.decrypt()
        }
    }

    fun getCurrentData(currentDate: String) = localDao.getSelectedTimeData(currentDate.encrypt()).map {
        LocalEntity(
            time = it.time.decrypt(),
            cpuName = it.cpuName.decrypt(),
            numberOfCores = it.numberOfCores.decrypt(),
            currentFrequenciesCpu1 = it.currentFrequenciesCpu1.decrypt(),
            currentFrequenciesCpu2 = it.currentFrequenciesCpu2.decrypt(),
            currentFrequenciesCpu3 = it.currentFrequenciesCpu3.decrypt(),
            currentFrequenciesCpu4 = it.currentFrequenciesCpu4.decrypt(),
            currentFrequenciesCpu5 = it.currentFrequenciesCpu5.decrypt(),
            currentFrequenciesCpu6 = it.currentFrequenciesCpu6.decrypt(),
            currentFrequenciesCpu7 = it.currentFrequenciesCpu7.decrypt(),
            currentFrequenciesCpu8 = it.currentFrequenciesCpu8.decrypt(),
            l1Chaces = it.l1Chaces.decrypt(),
            l2Chaces = it.l2Chaces.decrypt(),
            l3Chaces = it.l3Chaces.decrypt(),
            l4Chaces = it.l4Chaces.decrypt(),
            buildVersion = it.buildVersion.decrypt(),
            sdk = it.sdk.decrypt(),
            codeName = it.codeName.decrypt(),
            brand = it.brand.decrypt(),
            model = it.model.decrypt(),
            manufacturer = it.manufacturer.decrypt(),
            vm = it.vm.decrypt(),
            kernel = it.kernel.decrypt(),
            nativeHeapSize = it.nativeHeapSize.decrypt(),
            nativeHeapFreeSize = it.nativeHeapFreeSize.decrypt(),
            usedMemInBytes = it.usedMemInBytes.decrypt(),
            usedMemInPercentage = it.usedMemInPercentage.decrypt()
        )
    }
}