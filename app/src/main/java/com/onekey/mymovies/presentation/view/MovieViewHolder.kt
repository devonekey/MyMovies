package com.onekey.mymovies.presentation.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.databinding.ViewMovieBinding

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ViewMovieBinding.bind(itemView)

    fun bind(movie: Movie?) {
        if (movie == null) {
            return
        }

        with(binding) {
            item = movie
            titleTextView.isSelected = true
        }
    }
}
