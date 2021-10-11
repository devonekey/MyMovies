package com.onekey.mymovies.presentation.view

import android.view.View
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.databinding.ViewMovieBinding

class MovieViewHolder(
    itemView: View,
    val navController: NavController
) : RecyclerView.ViewHolder(itemView) {
    private val binding = ViewMovieBinding.bind(itemView)

    fun bind(movie: Movie?) {
        if (movie == null) {
            return
        }

        with(binding) {
            navController = this@MovieViewHolder.navController
            toMovieDetail = MainFragmentDirections.actionMainToMovieDetail(layoutPosition)
            item = movie
            titleTextView.isSelected = true
        }
    }
}
