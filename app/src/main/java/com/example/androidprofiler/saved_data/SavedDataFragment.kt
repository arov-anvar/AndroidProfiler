package com.example.androidprofiler.saved_data

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R
import com.example.androidprofiler.saved_data.selected_data.SelectedDataFragment

class SavedDataFragment : Fragment(R.layout.save_data_fragment), SavedDataAdapter.OnNoteListener {

    private val list = mutableListOf<String>()
    private val adapter = SavedDataAdapter(list, this)

    private val viewModel: SavedDataViewModel by lazy {
        SavedDataBuilder().build(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.rvDate).adapter = adapter
        viewModel.rvData.observe(this, {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onNoteClick(position: Int) {
        fragmentManager?.beginTransaction()
            ?.replace(R.id.nav_host, SelectedDataFragment(list[position]))
            ?.addToBackStack("savedData")?.commit()
    }
}