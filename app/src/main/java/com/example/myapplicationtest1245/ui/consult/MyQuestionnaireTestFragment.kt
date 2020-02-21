package com.example.myapplicationtest1245.ui.consult


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_questionnaire_test.*
import kotlinx.android.synthetic.main.my_questionnaire_test_cell.*
import kotlinx.android.synthetic.main.my_questionnaire_test_cell.view.*

/**
 * A simple [Fragment] subclass.
 */
class MyQuestionnaireTestFragment : Fragment() {
    private lateinit var myQuestionnaireTestViewModel: MyQuestionnaireTestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questionnaire_test, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imageViewChevronLeft2.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_questionnaireTestFragment_to_myQuestionnaireFragment)
        }
        val myQuestionnaireTestAdapter = MyQuestionnaireTestAdapter()
        recyclerViewMyQuestionnaireTest.apply {
            adapter = myQuestionnaireTestAdapter
            layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        }
        recyclerViewMyQuestionnaireTest.setNestedScrollingEnabled(false)
        myQuestionnaireTestViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(requireActivity().application)).get(MyQuestionnaireTestViewModel::class.java)
        myQuestionnaireTestViewModel.photoListLive.observe(viewLifecycleOwner, Observer {
            myQuestionnaireTestAdapter.submitList(it)
//            swipeLayoutGallery.isRefreshing = false
        })
        myQuestionnaireTestViewModel.photoListLive.value?:myQuestionnaireTestViewModel.fetchData()

//        swipeLayoutGallery.setOnRefreshListener {
//            galleryViewModel.fetchData()
//        }
    }
}
