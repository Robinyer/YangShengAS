package com.example.myapplicationtest1245.ui.mall

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.myapplicationtest1245.ui.home.viewpager2.PhotoItem
import kotlinx.android.synthetic.main.best_seller_cell.view.*

class MallBestSellerAdapter : ListAdapter<PhotoItem, MyViewHolder>(DIFFCALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.best_seller_cell,
                parent,
                false
            )
        )
//        holder.itemView.setOnClickListener {
//            Bundle().apply {
//                putParcelableArrayList("PHOTO_LIST", ArrayList(currentList))
//                putInt("PHOTO_POSITION", holder.adapterPosition)
//                holder.itemView.findNavController()
//                    .navigate(R.id.action_galleryFragment_to_pagerPhotoFragment, this)
//            }
//        }

        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.itemView.shimmerLayoutBestSeller.apply {
//            setShimmerColor(0x55FFFFFF)
//            setShimmerAngle(0)
//            startShimmerAnimation()
//        }
        val photoItem = getItem(position)
        with(holder.itemView) {
            shimmerLayoutBestSeller.apply {
                setShimmerColor(0x55FFFFFF)
                setShimmerAngle(0)
                startShimmerAnimation()
            }
            textViewBestSellerDescribe.text = photoItem.photoUser+"杯|奥氏体304食品级不锈钢"
            textViewBestSellerPrice.text = "¥"+photoItem.photoLikes.toString()
            textViewBestSellerNumber.text = photoItem.photoFavorites.toString()+"人付款"
        }

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
                    return false.also { holder.itemView.shimmerLayoutBestSeller?.stopShimmerAnimation() }
                }

            })
            .into(holder.itemView.imageViewBestSeller)

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


class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)