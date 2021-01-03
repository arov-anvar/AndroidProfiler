package com.example.androidprofiler.saved_data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R

class SavedDataAdapter(private val mData: List<String>, private val onNoteListener: OnNoteListener) : RecyclerView.Adapter<SavedDataAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private val onNoteListener: OnNoteListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener.onNoteClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_time_data, parent, false)
        return ViewHolder(view, onNoteListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.dataTxt).text = mData[position]
    }

    override fun getItemCount(): Int = mData.size

    interface OnNoteListener {
        fun onNoteClick(position: Int)
    }
}