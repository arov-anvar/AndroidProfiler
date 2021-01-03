package com.example.androidprofiler.generate_data.model.repository

import android.app.ActivityManager
import android.os.Build
import android.util.Log
import androidx.annotation.WorkerThread
import com.example.androidprofiler.generate_data.model.local_data_source.LocalDao
import com.example.androidprofiler.generate_data.model.local_data_source.LocalEntity
import com.example.androidprofiler.generate_data.model.provider.CpuProvider
import com.example.androidprofiler.generate_data.ui.AdapterItem
import java.util.*

class GenerateDataRepository(
    private val cpuProvider: CpuProvider,
    private val activityManager: ActivityManager,
    private val localDao: LocalDao
) {

    fun getCpuData(): List<AdapterItem> {
        val list = mutableListOf<AdapterItem>()

        cpuProvider.apply {

            // CPU
            list.add(AdapterItem("Процессор:", getCpuName()))

            list.add(AdapterItem("Количество ядер:", getNumberOfCores().toString()))

            for (core in 0 until getNumberOfCores()) {
                list.add(AdapterItem("Ядро $core:", "${getCurrentFrequenciesCpu(core)} мгц"))
            }

            list.add(AdapterItem("Abi: ", getAbi()))

            list.add(AdapterItem("L1 chaches: ", getL1Caсhes()))
            list.add(AdapterItem("L2 chaches: ", getL2Caсhes()))
            list.add(AdapterItem("L3 chaches: ", getL3Caсhes()))
            list.add(AdapterItem("L4 chaches: ", getL4Caсhes()))


            // ANDROID
            list.add(AdapterItem("Build version: ", Build.VERSION.RELEASE))
            list.add(AdapterItem("SDK: ", Build.VERSION.SDK_INT.toString()))
            list.add(AdapterItem("Codename: ", Build.VERSION.CODENAME))
            list.add(AdapterItem("Производитель: ", Build.BRAND))
            list.add(AdapterItem("Модель: ", Build.MODEL))
            list.add(AdapterItem("Мануфактура: ", Build.MANUFACTURER))
            list.add(AdapterItem("VM: ", getVmVersion()))
            list.add(AdapterItem("Kernel: ", System.getProperty("os.version") ?: ""))


            // RAM
            val memoryInfo = ActivityManager.MemoryInfo()
            activityManager.getMemoryInfo(memoryInfo)
            val nativeHeapSize = memoryInfo.totalMem
            val nativeHeapFreeSize = memoryInfo.availMem
            val usedMemInBytes = nativeHeapSize - nativeHeapFreeSize
            val usedMemInPercentage = usedMemInBytes * 100 / nativeHeapSize

            list.add(AdapterItem("Объем: ", "$nativeHeapSize байт"))
            list.add(AdapterItem("Свободно: ", "$nativeHeapFreeSize байт"))
            list.add(AdapterItem("Используется: ", "$usedMemInBytes байт"))
            list.add(AdapterItem("Процент: ", "$usedMemInPercentage %"))
        }
        return list
    }

    private fun getVmVersion(): String {
        var vm = "Dalvik"
        val vmVersion = System.getProperty("java.vm.version")
        if (vmVersion != null && vmVersion.startsWith("2")) {
            vm = "ART"
        }
        return vm
    }

    suspend fun saveData(listData: List<AdapterItem>) {
        val time = Calendar.getInstance().time.toString()
        val localEntity = LocalEntity(
            time = time,
            cpuName = listData[0].data,
            numberOfCores = listData[1].data,
            currentFrequenciesCpu1 = listData[2].data,
            currentFrequenciesCpu2 = listData[3].data,
            currentFrequenciesCpu3 = listData[4].data,
            currentFrequenciesCpu4 = listData[5].data,
            currentFrequenciesCpu5 = listData[6].data,
            currentFrequenciesCpu6 = listData[7].data,
            currentFrequenciesCpu7 = listData[8].data,
            currentFrequenciesCpu8 = listData[9].data,
            l1Chaces = listData[10].data,
            l2Chaces = listData[11].data,
            l3Chaces = listData[12].data,
            l4Chaces = listData[13].data,
            buildVersion = listData[14].data,
            sdk = listData[15].data,
            codeName = listData[16].data,
            brand = listData[17].data,
            model = listData[18].data,
            manufacturer = listData[19].data,
            vm = listData[20].data,
            kernel = listData[21].data,
            nativeHeapSize = listData[22].data,
            nativeHeapFreeSize = listData[23].data,
            usedMemInBytes = listData[24].data,
            usedMemInPercentage = listData[25].data
        )
        localDao.insert(localEntity)
    }
}