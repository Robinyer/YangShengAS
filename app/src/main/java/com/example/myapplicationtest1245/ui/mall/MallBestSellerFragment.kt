package com.example.myapplicationtest1245.ui.mall


import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.myapplicationtest1245.R
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader

import kotlinx.android.synthetic.main.fragment_mall_best_seller.*

/**
 * A simple [Fragment] subclass.
 */
class MallBestSellerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mall_best_seller, container, false)
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

        banner.setImages(arrayOf)
//        banner.setDelayTime(200)
        banner.isAutoPlay(true)
        banner.setBannerTitles(arrayListOf<String>("分筋错骨手", "破水火焰手", "肿透半边天"))
        banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
//                imageView?.setImageURI(path as Uri)
                if (context != null) {
                    if (imageView != null) {
                        Glide.with(context).load(path).into(imageView)
                    }
                }
            }

        })
        banner.setIndicatorGravity(BannerConfig.CENTER)
        banner.setBannerAnimation(Transformer.Default)
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        banner.start()
//        banner.dispatchTouchEvent()
    }

}
