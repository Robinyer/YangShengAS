package com.example.myapplicationtest1245.ui.profile


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.myapplicationtest1245.R
import com.example.myapplicationtest1245.ui.home.ProfileViewModel
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val textView: TextView = root.findViewById(R.id.text_profile)
        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val arrayOf = arrayListOf<Int>(R.drawable.image1, R.drawable.image2, R.drawable.image3)
//        arrayListOf<String>("分筋错骨手","破水火焰手","肿透半边天")
        val arrayOf = arrayListOf<String>(
            "https://img.zcool.cn/community/011ad05e27a173a801216518a5c505.jpg",
            "https://img.zcool.cn/community/01b8ac5e27a173a80120a895be4d85.jpg",
            "https://img.zcool.cn/community/013c7d5e27a174a80121651816e521.jpg"
        )

        banner2.setImages(arrayOf)
//        banner.setDelayTime(200)
        banner2.isAutoPlay(true)
//        banner2.setBannerTitles(arrayListOf<String>("分筋错骨手", "破水火焰手", "肿透半边天"))
        banner2.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
//                imageView?.setImageURI(path as Uri)
                if (context != null) {
                    if (imageView != null) {
                        Glide.with(context).load(path).into(imageView)
                    }
                }
            }

        })
        banner2.setIndicatorGravity(BannerConfig.CENTER)
        banner2.setBannerAnimation(Transformer.Default)
//        banner2.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        banner2.start()
    }

}