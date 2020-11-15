package com.example.androidprofiler.cpu.model.interactor

import com.example.androidprofiler.cpu.model.provider.CpuProvider
import com.example.androidprofiler.cpu.view.CpuAdapterItem

class CpuInteractorImpl(private val cpuProvider: CpuProvider): CpuInteractor {

    override fun getCpuData(): List<CpuAdapterItem> {
        val list = mutableListOf<CpuAdapterItem>()

        cpuProvider.apply {
            list.add(CpuAdapterItem("Процессор:", getCpuName()))

            list.add(CpuAdapterItem("Количество ядер:", getNumberOfCores().toString()))

            for (core in 0 until getNumberOfCores()) {
                list.add(CpuAdapterItem("Ядро $core:", "${getCurrentFrequenciesCpu(core)} мгц"))
            }
        }
        return list
    }
}