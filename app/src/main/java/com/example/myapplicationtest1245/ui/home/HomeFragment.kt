package com.example.myapplicationtest1245.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplicationtest1245.R
import com.example.myapplicationtest1245.ui.home.viewpager2.ConcernFragment
import com.example.myapplicationtest1245.ui.home.viewpager2.NearbyFragment
import com.example.myapplicationtest1245.ui.home.viewpager2.RecommendFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var position = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        position = this.homeViewModel.position

        return root

    }

//    override fun onResume() {
//        super.onResume()
//        viewPager2.adapter = object : FragmentStateAdapter(this) {
//            override fun getItemCount() = 3
//
//            override fun createFragment(position: Int) =
//                when (position) {
//                    0 -> ConcernFragment()
//                    1 -> RecommendFragment()
//                    else -> NearbyFragment()
//                }
//        }
////        viewPager2.setCurrentItem(1)
//
//        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//            when (position) {
//                0 -> tab.text = "关注"
//                1 -> tab.text = "推荐"
//                else -> tab.text = "附近"
//            }
//        }.attach()
//
////        tablayout.getTabAt(1).select();
////        viewPager2.run { viewPager2.currentItem = 1 }
//        viewPager2.setCurrentItem(1)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(viewPager2Home.adapter == null){
            viewPager2Home.adapter = object : FragmentStateAdapter(this) {
                override fun getItemCount() = 3

                override fun createFragment(position: Int) =
                    when (position) {
                        0 -> ConcernFragment()
                        1 -> RecommendFragment()
                        else -> NearbyFragment()
                    }
            }
//        viewPager2.setCurrentItem(1)
            TabLayoutMediator(tabLayoutHome, viewPager2Home) { tab, position ->
                when (position) {
                    0 -> tab.text = "关注"
                    1 -> tab.text = "推荐"
                    else -> tab.text = "附近"
                }
            }.attach()

        }
        tabLayoutHome.getTabAt(1)?.select()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if(viewPager2Home.adapter == null){
//            viewPager2Home.adapter = object : FragmentStateAdapter(this) {
//                override fun getItemCount() = 3
//
//                override fun createFragment(position: Int) =
//                    when (position) {
//                        0 -> ConcernFragment()
//                        1 -> RecommendFragment()
//                        else -> NearbyFragment()
//                    }
//            }
////        viewPager2.setCurrentItem(1)
//            TabLayoutMediator(tabLayoutHome, viewPager2Home) { tab, position ->
//                when (position) {
//                    0 -> tab.text = "关注"
//                    1 -> tab.text = "推荐"
//                    else -> tab.text = "附近"
//                }
//            }.attach()
//
//        }
//        tabLayoutHome.getTabAt(1)?.select()


//        viewPager2.run { viewPager2.currentItem = 1 }
//        viewPager2.setCurrentItem(1)
//        tabLayout.setSelectedTabIndicator(1)
    }


}