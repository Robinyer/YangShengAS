package com.example.myapplicationtest1245.ui.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtest1245.R
import com.example.myapplicationtest1245.ui.home.viewpager2.PhotoItem
import kotlinx.android.synthetic.main.my_questionnaire_test_cell.view.*


//import kotlinx.android.synthetic.main.gallery_cell.view.*

class MyQuestionnaireTestAdapter : ListAdapter<PhotoItem, MyViewHolder>(DIFFCALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.my_questionnaire_test_cell,
                parent,
                false
            )
        )
        val nextHolder = MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.my_questionnaire_test_cell,
                parent,
                false
            )
        )

        holder.itemView.setOnClickListener {
            Bundle().apply {
                //                putParcelableArrayList("PHOTO_LIST", ArrayList(currentList))
//                putInt("PHOTO_POSITION",holder.adapterPosition)
//                holder.itemView.findNavController().navigate(R.id.action_galleryFragment_to_pagerPhotoFragment,this)
                if (holder.itemView.radioGroupMyQuestionnaireTest.visibility == View.GONE)
                    holder.itemView.radioGroupMyQuestionnaireTest.setVisibility(View.VISIBLE)
                else
                    holder.itemView.radioGroupMyQuestionnaireTest.setVisibility(View.GONE)

            }
        }
        holder.itemView.radioGroupMyQuestionnaireTest.setOnCheckedChangeListener { group, checkedId ->
            holder.itemView.radioGroupMyQuestionnaireTest.setVisibility(View.GONE)
        }
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val photoItem = getItem(position)
//        textViewMyQuestionnaireTestCell.text
//            .text = photoItem.photoUser
//        textViewQuestionnaireIntroduction.text = photoItem.photoLikes.toString() +"睡眠到底够不够，好不好，让专家给您分析一下吧~"
        with(holder.itemView) {
            val showPosition = position + 1
            textViewMyQuestionnaireTestCell.text =
                (position + 1).toString() + "、" + photoItem.photoUser
//            .text = photoItem.photoLikes.toString() +"睡眠到底够不够，好不好，让专家给您分析一下吧~"
        }
        holder.itemView.radioGroupMyQuestionnaireTest.setVisibility(View.GONE)
        if (position == 0)
            holder.itemView.radioGroupMyQuestionnaireTest.setVisibility(View.VISIBLE)


//        holder.itemView.shimmerLayoutCell.apply {
//            setShimmerColor(0x55FFFFFF)
//            setShimmerAngle(0)
//            startShimmerAnimation()
//        }
//        Glide.with(holder.itemView)
//            .load(getItem(position).previewUrl)
//            .placeholder(R.drawable.ic_photo_gray_24dp)
//            .listener(object : RequestListener<Drawable> {
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    return false.also {}
//                }
//
//            })
//            .into(holder.itemView.imageViewMyQuestionnaireTest)

    }

    object DIFFCALLBACK : DiffUtil.ItemCallback<PhotoItem>() {
        override fun areItemsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PhotoItem, newItem: PhotoItem): Boolean {
            return oldItem.photoId == newItem.photoId
        }
    }

}

