package com.onekey.mymovies

import java.util.Date

data class MoviesResult(
    val lastBuildDate: Date,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Movie?>
)
