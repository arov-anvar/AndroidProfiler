package com.example.androidprofiler.saved_data.selected_data

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R

class SelectedDataFragment(private val currentDate: String): Fragment(R.layout.selected_data_fragment) {

    private val list = mutableListOf<String>()
    private val adapter = SelectedDataAdapter(list)

    private val viewModel: SelectedDataViewModel by lazy {
        SelectedDataBuilder().build(this, currentDate)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.dataRV).adapter = adapter

        viewModel.currentData.observe(this, {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
}