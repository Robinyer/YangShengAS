package com.example.myapplicationtest1245.ui.consult



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_questionnaire_test.*
import kotlinx.android.synthetic.main.my_questionnaire_cell.*

/**
 * A simple [Fragment] subclass.
 */
class MyQuestionnaireCellFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_questionnaire_cell, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonStartEvaluation.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_myQuestionnaireFragment_to_questionnaireTestFragment)
            print("XXXXX")
        }
    }
}
