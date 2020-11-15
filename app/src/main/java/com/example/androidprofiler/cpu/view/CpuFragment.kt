package com.example.androidprofiler.cpu.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R
import com.example.androidprofiler.cpu.CpuAssembler
import com.example.androidprofiler.cpu.presenter.CpuPresenter

class CpuFragment : Fragment(R.layout.fragment_cpu), CpuView {

    private val list = mutableListOf<CpuAdapterItem>()
    private val adapter = CpuAdapter(list)
    private lateinit var presenter: CpuPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataRV = view.findViewById<RecyclerView>(R.id.dataRV)
        dataRV.adapter = adapter

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                presenter.updateData()
                handler.postDelayed(this, 200)
            }
        }, 200)

        CpuAssembler().assemble(this)
    }

    override fun showNewData(data: List<CpuAdapterItem>) {
        list.clear()
        list.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun setPresenter(presenter: CpuPresenter) {
        this.presenter = presenter
    }
}