package com.example.myapplicationtest1245.ui.home.viewpager2


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager

import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_recommend.*
import androidx.lifecycle.Observer

/**
 * A simple [Fragment] subclass.
 */
class RecommendFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.swipeIndicator -> {
//                swipeLayoutGallery.isRefreshing = true
//                Handler().postDelayed(Runnable { galleryViewModel.fetchData() }, 1000)
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu, menu)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        setHasOptionsMenu(true)
        val postAdapter = PostAdapter()
        recyclerViewPost.apply {
            adapter = postAdapter
            layoutManager = GridLayoutManager(requireContext(), 1)
        }


        val postViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(PostViewModel::class.java)
        postViewModel.photoListLive.observe(viewLifecycleOwner, Observer {
            postAdapter.submitList(it)
            swipeLayoutPost.isRefreshing = false
        })

        postViewModel.photoListLive.value ?: postViewModel.fetchData()

        swipeLayoutPost.setOnRefreshListener {
            postViewModel.fetchData()
        }


        //

//        setHasOptionsMenu(true)
        val recommendChoiceAdapter = RecommendChoiceAdapter()
        recyclerViewRecommedChoice.apply {
            adapter = recommendChoiceAdapter
            layoutManager = GridLayoutManager(requireContext(),1,GridLayoutManager.HORIZONTAL,false)
//                LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }

        val recommendChoiceViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(RecommendChoiceViewModel::class.java)
        recommendChoiceViewModel.photoListLive.observe(viewLifecycleOwner, Observer {
            recommendChoiceAdapter.submitList(it)
//            swipeLayoutRecommend.isRefreshing = false
        })

        recommendChoiceViewModel.photoListLive.value ?: recommendChoiceViewModel.fetchData()

//        swipeLayoutGallery.setOnRefreshListener {
//            galleryViewModel.fetchData()
//        }

    }

}
