package com.onekey.mymovies.presentation.view

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.onekey.mymovies.R
import com.onekey.mymovies.data.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(movie: Movie?) {
        if (movie == null) {
            return
        }

        Picasso.get()
            .load(movie.image)
            .into(itemView.findViewById<AppCompatImageView>(R.id.thumbnail_image_view))
        itemView.findViewById<AppCompatTextView>(R.id.title_text_view)
            .apply {
                text = movie.title
                isSelected = true
            }
    }
}
