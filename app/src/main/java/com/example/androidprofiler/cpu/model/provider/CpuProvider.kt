package com.example.androidprofiler.cpu.model.provider

interface CpuProvider {
    fun getCurrentFrequenciesCpu(coreNumber: Int): Long
    fun getNumberOfCores(): Int
    fun getAbi(): String
    fun getCpuName(): String
}