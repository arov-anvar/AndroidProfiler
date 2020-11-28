package com.example.androidprofiler.cpu.model.provider

import android.os.Build
import android.util.Log
import java.io.RandomAccessFile

class CpuProviderImpl(private val cpuNativeProvider: CpuNativeProvider) : CpuProvider {

    private val CPU_INFO_DIR = "/sys/devices/system/cpu/"

    override fun getCurrentFrequenciesCpu(coreNumber: Int): Long {
        val currentFreqPath = "${CPU_INFO_DIR}cpu$coreNumber/cpufreq/scaling_cur_freq"
        return try {
            RandomAccessFile(currentFreqPath, "r").use { it.readLine().toLong() / 1000 }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            -1
        }
    }

    override fun getNumberOfCores(): Int = Runtime.getRuntime().availableProcessors()

    override fun getAbi(): String = Build.SUPPORTED_ABIS[0]

    override fun getCpuName(): String {
        return cpuNativeProvider.getCpuName()
    }

    override fun getL1Caсhes(): String = getCachesStrFromIntArray(cpuNativeProvider.getL1Caches())

    override fun getL2Caсhes(): String = getCachesStrFromIntArray(cpuNativeProvider.getL2Caches())

    override fun getL3Caсhes(): String = getCachesStrFromIntArray(cpuNativeProvider.getL3Caches())

    override fun getL4Caсhes(): String = getCachesStrFromIntArray(cpuNativeProvider.getL4Caches())

    private fun getCachesStrFromIntArray(intArray: IntArray?): String {
        var str = ""
        intArray?.forEach {
            str += "$it кб \n"
        }
        return if (str.isNotEmpty()) str.substring(0, str.length - 2) else str
    }

}