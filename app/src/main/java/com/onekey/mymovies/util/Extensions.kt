package com.onekey.mymovies.util

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("visibleIf")
fun View.setVisibleIf(condition: Any?) {
    visibility = when (condition) {
        is Boolean -> if (condition) View.VISIBLE else View.GONE
        is String -> if (condition.isNotBlank()) View.VISIBLE else View.GONE
        else -> View.GONE
    }
}

@BindingAdapter("android:src")
fun AppCompatImageView.setImage(imageUrl: String?) {
    if (imageUrl == null) {
        return
    }

    Picasso.get()
        .load(imageUrl)
        .into(this)
}
