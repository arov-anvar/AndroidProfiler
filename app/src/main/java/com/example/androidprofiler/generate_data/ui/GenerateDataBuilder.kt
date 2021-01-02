package com.example.androidprofiler.generate_data.ui

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.androidprofiler.AndroidProfilerApp
import com.example.androidprofiler.generate_data.model.provider.CpuNativeProvider
import com.example.androidprofiler.generate_data.model.provider.CpuProviderImpl
import com.example.androidprofiler.generate_data.model.repository.GenerateDataRepository

class GenerateDataBuilder {
    @SuppressLint("ServiceCast")
    fun build(fragment: Fragment): GenerateDataViewModel {
        val cpuNativeProvider = CpuNativeProvider()
        val cpuProvider = CpuProviderImpl(cpuNativeProvider)
        val activityManager = fragment.requireContext().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val localDao = (fragment.activity?.application as AndroidProfilerApp).database.localDao()
        val repository = GenerateDataRepository(cpuProvider, activityManager, localDao)
        return GenerateDataViewModel(repository)
    }
}