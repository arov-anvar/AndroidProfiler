package com.example.androidprofiler.screen

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprofiler.R
import com.example.androidprofiler.cpu.view.AdapterItem
import com.example.androidprofiler.cpu.view.DataAdapter

class ScreenFragment : Fragment(R.layout.fragment_cpu) {

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

        list.add(AdapterItem("Тип дисплея", getTypeDisplay()))

        if (Build.VERSION.SDK_INT >= 30) {
            val metrics = DisplayMetrics()
            val width = metrics.widthPixels
            val height = metrics.heightPixels
            val density = metrics.density
            val dpWidth = width / density
            val dpHeight = height / density

            list.add(AdapterItem("Ширина", "$width px"))
            list.add(AdapterItem("Высота", "$height px"))
            list.add(AdapterItem("Ширина(dp)", "$dpWidth dp"))
            list.add(AdapterItem("Высота(dp)", "$dpHeight dp"))
        } else {
            val metrics = activity?.windowManager?.defaultDisplay
            val width = metrics?.width ?: 0
            val height = metrics?.height ?: 0
            val density = context?.resources?.displayMetrics?.density ?: 1f
            val dpWidth = width / density
            val dpHeight = height / density

            list.add(AdapterItem("Ширина", "$width px"))
            list.add(AdapterItem("Высота", "$height px"))
            list.add(AdapterItem("Ширина(dp)", "$dpWidth dp"))
            list.add(AdapterItem("Высота(dp)", "$dpHeight dp"))
        }

        adapter.notifyDataSetChanged()
    }

    private fun getTypeDisplay(): String {
        val densityDpi = resources.displayMetrics.densityDpi

        val densityClass: String
        when (densityDpi) {
            DisplayMetrics.DENSITY_LOW -> {
                densityClass = "ldpi"
            }

            DisplayMetrics.DENSITY_MEDIUM -> {
                densityClass = "mdpi"
            }

            DisplayMetrics.DENSITY_TV, DisplayMetrics.DENSITY_HIGH -> {
                densityClass = "hdpi"
            }

            DisplayMetrics.DENSITY_XHIGH, DisplayMetrics.DENSITY_280 -> {
                densityClass = "xhdpi"
            }

            DisplayMetrics.DENSITY_XXHIGH, DisplayMetrics.DENSITY_360, DisplayMetrics.DENSITY_400,
            DisplayMetrics.DENSITY_420 -> {
                densityClass = "xxhdpi"
            }

            DisplayMetrics.DENSITY_XXXHIGH, DisplayMetrics.DENSITY_560 -> {
                densityClass = "xxxhdpi"
            }

            else -> {
                densityClass = ""
            }
        }

        return densityClass
    }
}