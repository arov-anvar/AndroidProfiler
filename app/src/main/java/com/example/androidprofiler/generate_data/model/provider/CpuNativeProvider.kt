package com.example.androidprofiler.generate_data.model.provider

class CpuNativeProvider {

    external fun initLibrary()
    external fun getCpuName(): String
    external fun getL1Caches(): IntArray?
    external fun getL2Caches(): IntArray?
    external fun getL3Caches(): IntArray?
    external fun getL4Caches(): IntArray?
}