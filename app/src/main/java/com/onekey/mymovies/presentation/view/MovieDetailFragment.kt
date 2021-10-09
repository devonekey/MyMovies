package com.onekey.mymovies.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onekey.mymovies.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)

        return binding.root
    }
}
