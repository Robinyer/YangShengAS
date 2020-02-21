package com.example.myapplicationtest1245.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is challenge circle Fragment"
    }
    val text: LiveData<String> = _text
//    val position = 1
}