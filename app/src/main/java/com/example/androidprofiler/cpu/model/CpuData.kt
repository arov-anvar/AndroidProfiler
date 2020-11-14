package com.example.androidprofiler.cpu.model

import android.util.Log
import java.io.RandomAccessFile

class CpuData {

    private val CPU_INFO_DIR = "/sys/devices/system/cpu/"

    fun getCurrentFrequenciesCpu(coreNumber: Int): Long {
        val currentFreqPath = "${CPU_INFO_DIR}cpu$coreNumber/cpufreq/scaling_cur_freq"
        return try {
            RandomAccessFile(currentFreqPath, "r").use { it.readLine().toLong() / 1000 }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            -1
        }
    }

    fun getNumberOfCores(): Int = Runtime.getRuntime().availableProcessors()
}