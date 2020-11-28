package com.example.androidprofiler.android

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R
import com.example.androidprofiler.cpu.view.AdapterItem
import com.example.androidprofiler.cpu.view.DataAdapter

class AndroidFragment : Fragment(R.layout.fragment_cpu) {

    private val list = mutableListOf<AdapterItem>()
    private val adapter = DataAdapter(list)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataRV = view.findViewById<RecyclerView>(R.id.dataRV)
        dataRV.adapter = adapter
        updateData()
    }

    private fun updateData() {
        list.clear()

        list.add(AdapterItem("Build version", Build.VERSION.RELEASE))
        list.add(AdapterItem("SDK", Build.VERSION.SDK_INT.toString()))
        list.add(AdapterItem("Codename", Build.VERSION.CODENAME))
        list.add(AdapterItem("Производитель", Build.BRAND))
        list.add(AdapterItem("Модель", Build.MODEL))
        list.add(AdapterItem("Мануфактура", Build.MANUFACTURER))
        list.add(AdapterItem("VM", getVmVersion()))
        list.add(AdapterItem("Kernel", System.getProperty("os.version") ?: ""))

        adapter.notifyDataSetChanged()
    }

    private fun getVmVersion(): String {
        var vm = "Dalvik"
        val vmVersion = System.getProperty("java.vm.version")
        if (vmVersion != null && vmVersion.startsWith("2")) {
            vm = "ART"
        }
        return vm
    }
}