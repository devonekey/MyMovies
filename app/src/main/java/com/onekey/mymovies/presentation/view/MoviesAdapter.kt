package com.onekey.mymovies.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onekey.mymovies.R
import com.onekey.mymovies.data.Movie

class MoviesAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var movies: List<Movie?>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_movie, parent, false)
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies?.getOrNull(position))
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    fun addAll(movies: List<Movie?>?) {
        this.movies = movies

        notifyDataSetChanged()
    }
}
