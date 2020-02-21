package com.example.myapplicationtest1245.ui.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_consult.*

class ConsultFragment : Fragment() {

    private lateinit var consultViewModel: ConsultViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        consultViewModel =
            ViewModelProviders.of(this).get(ConsultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_consult, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
        consultViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewQuestionnaire.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_navigation_consult_to_myQuestionnaireFragment) }
    }


}