package com.example.myapplicationtest1245.ui.consult

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.myapplicationtest1245.ui.home.viewpager2.PhotoItem
import com.example.myapplicationtest1245.ui.home.viewpager2.Pixabay
import com.example.myapplicationtest1245.ui.home.viewpager2.VolleySingleton
import com.google.gson.Gson

class MyQuestionnaireViewModel(application: Application):AndroidViewModel(application)  {
    private val _postListLive = MutableLiveData<List<PhotoItem>>()
    val photoListLive : LiveData<List<PhotoItem>>
        get() = _postListLive

    fun fetchData() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            getUrl(),
            Response.Listener {
                _postListLive.value = Gson().fromJson(it, Pixabay::class.java).hits.toList()
            },
            Response.ErrorListener {
                Log.d("hello",it.toString())
            }
        )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }

    private fun getUrl():String {
        return "https://pixabay.com/api/?key=12472743-874dc01dadd26dc44e0801d61&q=${keyWords.random()}&per_page=100"
    }

    private val keyWords = arrayOf("cat", "dog", "car", "beauty", "phone", "computer", "flower", "animal")

}