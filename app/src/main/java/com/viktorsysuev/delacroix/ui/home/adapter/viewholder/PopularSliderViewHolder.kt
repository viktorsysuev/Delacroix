package com.viktorsysuev.delacroix.ui.home.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.databinding.ItemPopularSliderBinding
import com.viktorsysuev.delacroix.ui.home.adapter.PopularSliderListAdapter
import com.viktorsysuev.delacroix.ui.home.adapter.SliderItemDecorator

class PopularSliderViewHolder(binding: ItemPopularSliderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val viewPool = RecyclerView.RecycledViewPool()
    private val adapter = PopularSliderListAdapter()

    init {
        binding.list.onFlingListener = null
        LinearSnapHelper().attachToRecyclerView(binding.list)
        binding.list.setRecycledViewPool(viewPool)
        binding.list.adapter = adapter
        binding.list.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.list.addItemDecoration(SliderItemDecorator())
    }

    fun bind(items: List<Photo>) {
        adapter.setData(items)
    }

    companion object {
        fun create(parent: ViewGroup): PopularSliderViewHolder {
            val binding = ItemPopularSliderBinding.inflate(LayoutInflater.from(parent.context))
            return PopularSliderViewHolder(binding)
        }
    }
}