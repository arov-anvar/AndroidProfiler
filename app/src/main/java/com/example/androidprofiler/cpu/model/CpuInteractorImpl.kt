package com.example.androidprofiler.cpu.model

import com.example.androidprofiler.cpu.view.CpuAdapterItem

class CpuInteractorImpl(private val cpuData: CpuData): CpuInteractor {

    override fun getCpuData(): List<CpuAdapterItem> {
        val list = mutableListOf<CpuAdapterItem>()

        cpuData.apply {
            list.add(CpuAdapterItem("Количество ядер:", getNumberOfCores().toString()))
            for (core in 0 until getNumberOfCores()) {
                list.add(CpuAdapterItem("Ядро $core:", "${getCurrentFrequenciesCpu(core)} мгц"))
            }
        }
        return list
    }
}