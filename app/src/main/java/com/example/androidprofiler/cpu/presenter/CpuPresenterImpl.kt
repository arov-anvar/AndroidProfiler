package com.example.androidprofiler.cpu.presenter

import com.example.androidprofiler.cpu.model.interactor.CpuInteractor
import com.example.androidprofiler.cpu.view.CpuView

class CpuPresenterImpl(private val view: CpuView, private val interactor: CpuInteractor) : CpuPresenter {

    override fun updateData() {
        view.showNewData(interactor.getCpuData())
    }
}