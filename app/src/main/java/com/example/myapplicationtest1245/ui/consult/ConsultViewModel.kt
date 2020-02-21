package com.example.myapplicationtest1245.ui.consult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConsultViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is consult Fragment"
    }
    val text: LiveData<String> = _text
}