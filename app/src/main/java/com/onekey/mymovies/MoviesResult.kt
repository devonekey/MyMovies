package com.onekey.mymovies

import java.util.Date

sealed class MoviesResult {
    abstract val items: List<Movie?>
    abstract val total: Int
    abstract val updated: Date

    data class ForOpenApi(
        val lastBuildDate: Date,
        override val total: Int,
        val start: Int,
        val display: Int,
        override val items: List<Movie.ForOpenApi?>
    ) : MoviesResult() {
        override val updated: Date
            get() = lastBuildDate
    }

    data class ForMobileApi(val data: Data) : MoviesResult() {
        override val items: List<Movie?>
            get() = data.result.itemList
        override val total: Int
            get() = data.result.total
        override val updated: Date
            get() = data.result.last_updated

        data class Data(val result: Result)

        data class Result(
            val total: Int,
            val opfield: String,
            val last_updated: Date,
            val itemcount: Int,
            val pc_more_url: String,
            val itemList: List<Movie.ForMobileApi?>
        )
    }
}
