package com.example.androidprofiler.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.androidprofiler.cpu.view.CpuFragment
import com.example.androidprofiler.R

private val TAB_TITLES = arrayOf(
        R.string.cpu,
        R.string.cpu
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment =
        when(position) {
            0 -> CpuFragment()
            else -> CpuFragment()
        }


    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount() = TAB_TITLES.size
}