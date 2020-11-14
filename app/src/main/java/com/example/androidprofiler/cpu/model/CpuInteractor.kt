package com.example.androidprofiler.cpu.model

import com.example.androidprofiler.cpu.view.CpuAdapterItem

interface CpuInteractor {
    fun getCpuData(): List<CpuAdapterItem>
}