package com.example.androidprofiler.cpu

import com.example.androidprofiler.cpu.model.CpuData
import com.example.androidprofiler.cpu.model.CpuInteractorImpl
import com.example.androidprofiler.cpu.presenter.CpuPresenterImpl
import com.example.androidprofiler.cpu.view.CpuView

class CpuAssembler {

    fun assemble(view: CpuView) {
        val cpuData = CpuData()
        val interactor = CpuInteractorImpl(cpuData)
        val presenter = CpuPresenterImpl(view, interactor)
        view.setPresenter(presenter)
    }
}