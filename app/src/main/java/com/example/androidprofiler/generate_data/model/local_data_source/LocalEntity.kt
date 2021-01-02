package com.example.androidprofiler.generate_data.model.local_data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_entity")
class LocalEntity (

    @PrimaryKey(autoGenerate = true) val id: Int = 1,
    val cpuName: String,
    val numberOfCores: String,
    val currentFrequenciesCpu1: String,
    val currentFrequenciesCpu2: String,
    val currentFrequenciesCpu3: String,
    val currentFrequenciesCpu4: String,
    val currentFrequenciesCpu5: String,
    val currentFrequenciesCpu6: String,
    val currentFrequenciesCpu7: String,
    val currentFrequenciesCpu8: String,
    val l1Chaces: String,
    val l2Chaces: String,
    val l3Chaces: String,
    val l4Chaces: String,
    val buildVersion: String,
    val sdk: String,
    val codeName: String,
    val brand: String,
    val model: String,
    val manufacturer: String,
    val vm: String,
    val kernel: String,
    val nativeHeapSize: String,
    val nativeHeapFreeSize: String,
    val usedMemInBytes: String,
    val usedMemInPercentage: String
)