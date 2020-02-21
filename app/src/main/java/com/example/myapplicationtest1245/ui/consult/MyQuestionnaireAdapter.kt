package com.example.myapplicationtest1245.ui.consult

import com.example.myapplicationtest1245.ui.home.viewpager2.PhotoItem
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.fragment_questionnaire_test.*
import kotlinx.android.synthetic.main.my_questionnaire_cell.view.*

class MyQuestionnaireAdapter : ListAdapter<PhotoItem, MyViewHolder>(
    DIFFCALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder =
            MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.my_questionnaire_cell,
                    parent,
                    false
                )
            )
//        holder.itemView.setOnClickListener {
//            Bundle().apply {
//                putParcelable("PHOTO",getItem(holder.adapterPosition))
////                holder.itemView.findNavController().navigate(R.id.action_galleryFragment_to_photoFragment,this)
//            }
//        }

        holder.itemView.buttonStartEvaluation.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_myQuestionnaireFragment_to_questionnaireTestFragment)
        }
//        holder.itemView.setOnClickListener {
//
//            Bundle().apply {
//
////                putParcelableArrayList("PHOTO_LIST", ArrayList(currentList))
////                putInt("PHOTO_POSITION",holder.adapterPosition)
//                holder.itemView.findNavController().navigate(R.id.action_myQuestionnaireFragment_to_questionnaireTestFragment,this)
//            }
//        }
//        holder.itemView.setOnClickListener(
//            Bundle().apply {
//
//            }
//        )
        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val photoItem = getItem(position)

        with(holder.itemView) {
            shimmerLayoutMyQuestionnarie.apply {
                setShimmerColor(0x55FFFFFF)
                setShimmerAngle(0)
                startShimmerAnimation()
            }
            textViewQuestionnaireName.text = photoItem.photoUser
            textViewQuestionnaireIntroduction.text = photoItem.photoLikes.toString() +"睡眠到底够不够，好不好，让专家给您分析一下吧~"


        }

//        holder.itemView.shimmerLayoutCell.apply {
//            setShimmerColor(0x55FFFFFF)
//            setShimmerAngle(0)
//            startShimmerAnimation()
//        }
        Glide.with(holder.itemView)
            .load(getItem(position).previewUrl)
            .placeholder(R.drawable.ic_photo_gray_24dp)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false.also { holder.itemView.shimmerLayoutMyQuestionnarie?.stopShimmerAnimation() }
                }

            })
            .into(holder.itemView.imageViewQuestionnaire)
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


class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)