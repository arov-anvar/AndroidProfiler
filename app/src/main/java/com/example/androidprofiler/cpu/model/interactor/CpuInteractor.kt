package com.example.androidprofiler.cpu.model.interactor

import com.example.androidprofiler.cpu.view.AdapterItem

interface CpuInteractor {
    fun getCpuData(): List<AdapterItem>
}