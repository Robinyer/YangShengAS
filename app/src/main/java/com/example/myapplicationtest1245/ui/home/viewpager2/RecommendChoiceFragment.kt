package com.example.myapplicationtest1245.ui.home.viewpager2

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.myapplicationtest1245.R

class RecommendChoiceFragment : Fragment() {

    companion object {
        fun newInstance() = RecommendChoiceFragment()
    }

    private lateinit var viewModel: RecommendChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recommend_choice_cell, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecommendChoiceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
