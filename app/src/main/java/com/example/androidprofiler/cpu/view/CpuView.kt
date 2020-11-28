package com.example.androidprofiler.cpu.view

import com.example.androidprofiler.cpu.presenter.CpuPresenter

interface CpuView {
    fun showNewData(data: List<AdapterItem>)
    fun setPresenter(presenter: CpuPresenter)
}