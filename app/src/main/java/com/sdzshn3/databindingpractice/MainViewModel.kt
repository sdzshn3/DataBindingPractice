package com.sdzshn3.databindingpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class MainViewModel: ViewModel() {

    val text = MutableLiveData<String>()

    init {
        text.value = "First try"
        Timer(false).schedule(5000) {

            text.postValue("From server.. Is it?")
        }
    }

}