package com.example.androidprofiler.ram

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R
import com.example.androidprofiler.cpu.view.AdapterItem
import com.example.androidprofiler.cpu.view.DataAdapter


class RamFragment : Fragment(R.layout.fragment_ram) {

    private val list = mutableListOf<AdapterItem>()
    private val adapter = DataAdapter(list)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataRV = view.findViewById<RecyclerView>(R.id.dataRV)
        dataRV.adapter = adapter

        updateData()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                updateData()
                handler.postDelayed(this, 200)
            }
        }, 200)
    }

    private fun updateData() {
        val memoryInfo = ActivityManager.MemoryInfo()
        ((requireContext().getSystemService(ACTIVITY_SERVICE)) as ActivityManager).getMemoryInfo(memoryInfo)
        val nativeHeapSize = memoryInfo.totalMem
        val nativeHeapFreeSize = memoryInfo.availMem
        val usedMemInBytes = nativeHeapSize - nativeHeapFreeSize
        val usedMemInPercentage = usedMemInBytes * 100 / nativeHeapSize

        list.clear()
        list.add(AdapterItem("Объем", "$nativeHeapSize байт"))
        list.add(AdapterItem("Свободно", "$nativeHeapFreeSize байт"))
        list.add(AdapterItem("Используется", "$usedMemInBytes байт"))
        list.add(AdapterItem("Процент", "$usedMemInPercentage %"))

        adapter.notifyDataSetChanged()
    }
}