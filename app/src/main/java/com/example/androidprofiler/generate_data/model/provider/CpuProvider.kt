package com.example.androidprofiler.generate_data.model.provider

interface CpuProvider {
    fun getCurrentFrequenciesCpu(coreNumber: Int): Long
    fun getNumberOfCores(): Int
    fun getAbi(): String
    fun getCpuName(): String
    fun getL1Caсhes(): String
    fun getL2Caсhes(): String
    fun getL3Caсhes(): String
    fun getL4Caсhes(): String
}