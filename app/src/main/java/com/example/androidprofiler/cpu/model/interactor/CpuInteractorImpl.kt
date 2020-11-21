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

            list.add(CpuAdapterItem("Abi", getAbi()))

            list.add(CpuAdapterItem("L1 chaches", getL1Caсhes()))
            list.add(CpuAdapterItem("L2 chaches", getL2Caсhes()))
            list.add(CpuAdapterItem("L3 chaches", getL3Caсhes()))
            list.add(CpuAdapterItem("L4 chaches", getL4Caсhes()))
        }
        return list
    }
}