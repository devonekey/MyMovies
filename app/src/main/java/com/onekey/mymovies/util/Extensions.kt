package com.onekey.mymovies.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:src")
fun AppCompatImageView.setImage(imageUrl: String) {
    Picasso.get()
        .load(imageUrl)
        .into(this)
}
