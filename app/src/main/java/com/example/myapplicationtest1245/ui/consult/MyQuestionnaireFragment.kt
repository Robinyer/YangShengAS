package com.example.myapplicationtest1245.ui.consult


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_my_questionnaire.*
import kotlinx.android.synthetic.main.fragment_recommend.*
import kotlinx.android.synthetic.main.my_questionnaire_cell.*
import kotlinx.android.synthetic.main.my_questionnaire_test_cell.*

/**
 * A simple [Fragment] subclass.
 */
class MyQuestionnaireFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_questionnaire, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewChevronLeft.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_myQuestionnaireFragment_to_navigation_consult) }
//        buttonStartEvaluation.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.action_myQuestionnaireFragment_to_questionnaireTestFragment) }

        super.onActivityCreated(savedInstanceState)
//        setHasOptionsMenu(true)
        val myQuestionnaireAdapter = MyQuestionnaireAdapter()
        recyclerViewMyQuestionnaire.apply {
            adapter = myQuestionnaireAdapter
            layoutManager = GridLayoutManager(requireContext(), 1)
        }

        val myQuestionnaireViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(MyQuestionnaireViewModel::class.java)
        myQuestionnaireViewModel.photoListLive.observe(viewLifecycleOwner, Observer {
            myQuestionnaireAdapter.submitList(it)
//            swipeLayoutPost.isRefreshing = false
        })
        myQuestionnaireViewModel.photoListLive.value ?: myQuestionnaireViewModel.fetchData()

//        swipeLayoutPost.setOnRefreshListener {
//            myQuestionnaireViewModel.fetchData()
//        }





    }
}
