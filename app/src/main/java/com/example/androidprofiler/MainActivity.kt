package com.example.androidprofiler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import java.io.RandomAccessFile

class MainActivity : AppCompatActivity() {

    private val CPU_INFO_DIR = "/sys/devices/system/cpu/"
    private val COUNT_OF_CORES = getNumberOfCores()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            override fun run() {
                var frequenciesCores = ""
                for (coreNumber in 0 until COUNT_OF_CORES) {
                    val currentFrequenciesCpu = getCurrentFrequenciesCpu(coreNumber)
                    frequenciesCores += "$coreNumber: $currentFrequenciesCpu мггц \n"
                }
                findViewById<TextView>(R.id.sample_text).text = frequenciesCores
                handler.postDelayed(this, 1000)
            }
        }, 1000)
    }

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    private fun getCurrentFrequenciesCpu(coreNumber: Int): Long {
        val currentFreqPath = "${CPU_INFO_DIR}cpu$coreNumber/cpufreq/scaling_cur_freq"
        return try {
            RandomAccessFile(currentFreqPath, "r").use { it.readLine().toLong() / 1000 }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            -1
        }
    }

    private fun getNumberOfCores(): Int = Runtime.getRuntime().availableProcessors()
}