package com.example.myapplicationtest1245.ui.home.viewpager2

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.myapplicationtest1245.R
import kotlinx.android.synthetic.main.post_cell.view.*

class PostAdapter : ListAdapter<PhotoItem, MyViewHolder>(
    DIFFCALLBACK
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder =
            MyViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.post_cell,
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

        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val photoItem = getItem(position)

        with(holder.itemView) {
            shimmerLayoutPostCell.apply {
                setShimmerColor(0x55FFFFFF)
                setShimmerAngle(0)
                startShimmerAnimation()
            }
            textViewPostUserName.text = photoItem.photoUser
            textViewLikes.text = photoItem.photoLikes.toString()
            //仍需更改部分
            textViewComments.text = photoItem.photoComments.toString()
            textViewLaunch.text = photoItem.photoFavorites.toString()
//            imageViewPost.layoutParams.height = photoItem.photoHeight

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
                    return false.also { holder.itemView.shimmerLayoutPostCell?.stopShimmerAnimation() }
                }

            })
            .into(holder.itemView.imageViewPost)

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
                    return false.also { holder.itemView.shimmerLayoutPostCell?.stopShimmerAnimation() }
                }

            })
            .into(holder.itemView.imageViewPostUser)
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