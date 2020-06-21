package com.sdzshn3.databindingpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.schedule

class RecyclerViewModel : ViewModel() {

    val androidsLiveData = MutableLiveData<List<Android>>()

    val androids: LiveData<List<Android>>
        get() = androidsLiveData

    init {
        val list = ArrayList<Android>()
        list.add(Android("Nougat"))
        list.add(Android("Oreo"))
        list.add(Android("Pie"))
        list.add(Android("10"))
        androidsLiveData.value = list

        Timer(false).schedule(5000) {
            list.add(Android("Nougat"))
            list.add(Android("Oreo"))
            list.add(Android("Pie"))
            list.add(Android("10"))
            list.add(Android("11 or Raspberry"))
            list.add(Android("Nougat"))
            list.add(Android("Oreo"))
            list.add(Android("Pie"))
            list.add(Android("10"))
            list.add(Android("11 or Raspberry"))
            androidsLiveData.postValue(list)
        }
    }
}