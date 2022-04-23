package com.viktorsysuev.delacroix.ui.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.ui.home.adapter.viewholder.PopularSliderViewHolder

sealed class MainUiModel

class PopularSliderItem(val photos: List<Photo>) : MainUiModel()
class NewestItem() : MainUiModel()

class HomeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val POPULAR_SLIDER_TYPE = 0
    private val NEWEST_SLIDER_TYPE = 1

    private var items: List<MainUiModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            POPULAR_SLIDER_TYPE -> PopularSliderViewHolder.create(parent)
            NEWEST_SLIDER_TYPE -> PopularSliderViewHolder.create(parent)
            else -> PopularSliderViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is PopularSliderItem -> (holder as PopularSliderViewHolder).bind(item.photos)
            else -> {

            }
        }
    }

    override fun getItemCount(): Int = items.count()

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is PopularSliderItem -> POPULAR_SLIDER_TYPE
            is NewestItem -> NEWEST_SLIDER_TYPE
        }
    }

    fun setData(items: List<MainUiModel>) {
        this.items = items
        notifyDataSetChanged()
    }
}