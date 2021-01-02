package com.example.androidprofiler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }

    companion object {
        init {
            System.loadLibrary("cpuinfo-libs")
        }
    }
}