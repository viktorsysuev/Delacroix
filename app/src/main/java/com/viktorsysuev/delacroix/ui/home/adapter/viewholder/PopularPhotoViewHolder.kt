package com.viktorsysuev.delacroix.ui.home.adapter.viewholder

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.viktorsysuev.delacroix.R
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.databinding.ItemPopularPhotoBinding

class PopularPhotoViewHolder(private val binding: ItemPopularPhotoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Photo) {
        val context = binding.root.context

        binding.name.text = item.user?.name
        Glide.with(context)
            .load(item.user?.profileImage?.small)
            .into(binding.avatar)
        binding.likes.text = item.likes.toString()

        Glide.with(context)
            .load(item.urls?.regular)
            .placeholder(
                ColorDrawable(
                    ContextCompat.getColor(
                        context,
                        R.color.grey
                    )
                )
            )
            .into(binding.mainPhoto)
    }


    companion object {

        fun create(parent: ViewGroup): PopularPhotoViewHolder {
            val binding = ItemPopularPhotoBinding.inflate(LayoutInflater.from(parent.context))
            return PopularPhotoViewHolder(binding)
        }
    }
}