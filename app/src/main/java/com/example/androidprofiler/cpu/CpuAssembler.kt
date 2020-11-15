package com.example.androidprofiler.cpu

import com.example.androidprofiler.cpu.model.provider.CpuProviderImpl
import com.example.androidprofiler.cpu.model.interactor.CpuInteractorImpl
import com.example.androidprofiler.cpu.model.provider.CpuNativeProvider
import com.example.androidprofiler.cpu.presenter.CpuPresenterImpl
import com.example.androidprofiler.cpu.view.CpuView

class CpuAssembler {

    fun assemble(view: CpuView) {
        val cpuProvider = CpuProviderImpl(CpuNativeProvider())
        val interactor = CpuInteractorImpl(cpuProvider)
        val presenter = CpuPresenterImpl(view, interactor)
        view.setPresenter(presenter)
    }
}