package com.example.androidprofiler

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.androidprofiler.generate_data.ui.GenerateDataFragment
import com.example.androidprofiler.saved_data.SavedDataFragment

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.dataBtn).setOnClickListener {
            changeFragment(R.id.nav_host, GenerateDataFragment())
        }

        view.findViewById<Button>(R.id.savedDataBtn).setOnClickListener {
            changeFragment(R.id.nav_host, SavedDataFragment())
        }
    }

    private fun changeFragment(layoutId: Int, fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(layoutId, fragment)?.addToBackStack("main")?.commit()
    }
}