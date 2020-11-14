package com.example.androidprofiler.cpu.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R

class CpuAdapter(private val mData: List<CpuAdapterItem>) : RecyclerView.Adapter<CpuAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cpu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.nameTxt).text = mData[position].name
        holder.itemView.findViewById<TextView>(R.id.dataTxt).text = mData[position].data
    }

    override fun getItemCount(): Int = mData.size
}