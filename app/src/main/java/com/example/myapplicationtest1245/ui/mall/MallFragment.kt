package com.example.myapplicationtest1245.ui.mall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplicationtest1245.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_mall.*

class MallFragment : Fragment() {

    private lateinit var mallViewModel: MallViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mallViewModel =
            ViewModelProviders.of(this).get(MallViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_mall, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        mallViewModel.text.observe(this, Observer {
////            textView.text = it
//        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(viewPager2Mall.adapter == null){
            viewPager2Mall.adapter = object : FragmentStateAdapter(this) {
                override fun getItemCount() = 7

                override fun createFragment(position: Int) =
                    when (position) {
                        0 -> MallBestSellerFragment()
                        1 -> MallMinorPrescriptionFragment()
                        else -> MallBestSellerFragment()
                    }

            }
//        viewPager2.setCurrentItem(1)
            TabLayoutMediator(tabLayoutMall, viewPager2Mall) { tab, position ->
                when (position) {
                    0 -> tab.text = "热销"
                    1 -> tab.text = "小方"
                    2 -> tab.text = "茶饮"
                    3 -> tab.text = "日用"
                    4 -> tab.text = "汤剂"
                    5 -> tab.text = "零食"
                    6 -> tab.text = "保健品"
                }
            }.attach()

        }
//        tabLayoutHome.getTabAt(1)?.select()



    }



}