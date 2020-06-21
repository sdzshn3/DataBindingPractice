package com.sdzshn3.databindingpractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel: ViewModel() {

    val text = MutableLiveData<String>()

    init {
        text.value = "First try"
        Timer(false).schedule(2500) {
            text.postValue("From server.. Is it?")
        }
    }

}