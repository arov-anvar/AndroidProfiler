package com.example.androidprofiler

import android.app.Application
import com.example.androidprofiler.generate_data.model.local_data_source.LocalDataBase

class AndroidProfilerApp : Application() {
    val database by lazy { LocalDataBase.getDatabase(this) }
}