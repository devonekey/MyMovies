package com.onekey.mymovies.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.onekey.mymovies.R
import com.onekey.mymovies.presentation.viewmodel.MoviesViewModel

class MoviesAdapter(
    private val navController: NavController,
    val viewModel: MoviesViewModel
) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_movie, parent, false),
            navController = navController
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(
            viewModel.currentlyShowingMovies
                .value
                ?.getOrNull(position)
        )
    }

    override fun getItemCount(): Int =
        viewModel.currentlyShowingMovies
            .value
            ?.size
            ?: 0
}
