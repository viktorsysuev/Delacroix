package com.viktorsysuev.delacroix.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.viktorsysuev.delacroix.databinding.FragmentHomeBinding
import com.viktorsysuev.delacroix.ui.home.adapter.HomeListAdapter
import com.viktorsysuev.delacroix.ui.home.adapter.PopularSliderItem
import com.viktorsysuev.delacroix.ui.util.collectWhenStarted

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val viewModel: HomeViewModel by viewModels { HomeViewModel.Companion }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentHomeBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchPopularPhotos()

        val adapter = HomeListAdapter()
        binding.list.adapter = adapter

        viewModel.photos.collectWhenStarted(lifecycleScope) {
            if (it is Success) {
                adapter.setData(listOf(PopularSliderItem(it.data)))
            }
        }
    }
}