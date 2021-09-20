package com.h6ah4i.android.example.viewpager2bugrepro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val logBuffer = MutableLiveData<String>()

    fun putLog(tag: String, msg: String) {
        logBuffer.value = "${logBuffer.value ?: ""}$tag: $msg\n"
    }
}