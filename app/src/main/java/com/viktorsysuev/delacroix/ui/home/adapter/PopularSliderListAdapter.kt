package com.viktorsysuev.delacroix.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.ui.home.adapter.viewholder.PopularPhotoViewHolder

class PopularSliderListAdapter : RecyclerView.Adapter<PopularPhotoViewHolder>() {

    private var items: List<Photo> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularPhotoViewHolder {
        return PopularPhotoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PopularPhotoViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.count()

    fun setData(items: List<Photo>) {
        this.items = items
        notifyDataSetChanged()
    }
}