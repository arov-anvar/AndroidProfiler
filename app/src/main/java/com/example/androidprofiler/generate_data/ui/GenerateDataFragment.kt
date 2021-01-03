package com.example.androidprofiler.generate_data.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R

class GenerateDataFragment : Fragment(R.layout.generate_data_fragment) {

    private val viewModel: GenerateDataViewModel by lazy {
        GenerateDataBuilder().build(this)
    }
    private val list = mutableListOf<AdapterItem>()
    private val adapter = DataAdapter(list)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.dataRV).adapter = adapter

        view.findViewById<Button>(R.id.saveBtn).setOnClickListener {
            viewModel.saveBtnClicked()
        }

        viewModel.rvData.observe(this@GenerateDataFragment, {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                viewModel.updateData()
                handler.postDelayed(this, 200)
            }
        }, 200)
    }
}