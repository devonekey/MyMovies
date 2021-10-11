package com.onekey.mymovies.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.databinding.FragmentMovieDetailBinding
import com.onekey.mymovies.presentation.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    @Inject lateinit var viewModel: MovieViewModel
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)

        viewModel.currentlyShowingMovie
            .observe(
                viewLifecycleOwner,
                { movie ->
                    binding.item = movie as Movie.ForMobileApi
                    binding.openDateTextView.text =
                        SimpleDateFormat(
                            "yyyy.MM.dd 개봉",
                            Locale.getDefault()
                        ).format(movie.opendate)
                }
            )
        viewModel.getCurrentlyShowingMovie(requireArguments().getInt("position"))

        return binding.root
    }
}
