package com.viktorsysuev.delacroix.ui.home

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bumptech.glide.Glide
import com.viktorsysuev.delacroix.R
import com.viktorsysuev.delacroix.data.model.Photo
import com.viktorsysuev.delacroix.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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
        viewModel.fetchRandomPhoto()

        binding.mainPhoto.setOnClickListener {
            viewModel.fetchRandomPhoto()
        }

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.photo.collectLatest {
                    if (it is Success<*>) {
                        val photo = it.data as Photo
                        Glide.with(requireContext())
                            .load(photo.urls.small)
                            .placeholder(
                                ColorDrawable(
                                    ContextCompat.getColor(
                                        requireContext(),
                                        R.color.grey
                                    )
                                )
                            )
                            .into(binding.mainPhoto)
                    }
                }
            }
        }
    }
}