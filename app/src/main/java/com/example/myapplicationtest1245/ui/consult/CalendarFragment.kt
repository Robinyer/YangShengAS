package com.example.myapplicationtest1245.ui.consult


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplicationtest1245.R
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarView
import kotlinx.android.synthetic.main.fragment_calendar.*

/**
 * A simple [Fragment] subclass.
 */
class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var tempString = ""
        when(calendarView.curMonth){
            1 -> tempString = "一月"
            2 -> tempString = "二月"
            3 -> tempString = "三月"
            4 -> tempString = "四月"
            5 -> tempString = "五月"
            6 -> tempString = "六月"
            7 -> tempString = "七月"
            8 -> tempString = "八月"
            9 -> tempString = "九月"
            10 -> tempString = "十月"
            11 -> tempString = "十一月"
            12 -> tempString = "十二月"
            else -> tempString = "月份错误"
        }
        textViewMonth.text = "${tempString}，今天"

    }

}
