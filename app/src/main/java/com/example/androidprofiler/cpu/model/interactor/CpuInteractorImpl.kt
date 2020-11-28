package com.example.androidprofiler.cpu.model.interactor

import com.example.androidprofiler.cpu.model.provider.CpuProvider
import com.example.androidprofiler.cpu.view.AdapterItem

class CpuInteractorImpl(private val cpuProvider: CpuProvider): CpuInteractor {

    override fun getCpuData(): List<AdapterItem> {
        val list = mutableListOf<AdapterItem>()

        cpuProvider.apply {
            list.add(AdapterItem("Процессор:", getCpuName()))

            list.add(AdapterItem("Количество ядер:", getNumberOfCores().toString()))

            for (core in 0 until getNumberOfCores()) {
                list.add(AdapterItem("Ядро $core:", "${getCurrentFrequenciesCpu(core)} мгц"))
            }

            list.add(AdapterItem("Abi", getAbi()))

            list.add(AdapterItem("L1 chaches", getL1Caсhes()))
            list.add(AdapterItem("L2 chaches", getL2Caсhes()))
            list.add(AdapterItem("L3 chaches", getL3Caсhes()))
            list.add(AdapterItem("L4 chaches", getL4Caсhes()))
        }
        return list
    }
}