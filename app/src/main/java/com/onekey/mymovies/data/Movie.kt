package com.onekey.mymovies.data

import java.util.Date

sealed class Movie {
    abstract val title: String
    abstract val image: String

    data class ForOpenApi(
        override val title: String,
        val link: String,
        override val image: String,
        val subtitle: String,
        val pubDate: String,
        val director: String,
        val actor: String,
        val userRating: String
    ) : Movie()

    data class ForMobileApi(
        val ktitle: String,
        val main_genre_name: String,
        val director_name: String,
        val actor_name: String,
        val opendate: Date,
        val mv_end: String,
        val review_cnt: String,
        val point_cnt: String,
        val actual_score: String,
        val runtime: String,
        val poster_img_org: String,
        val poster_img: String,
        val poster_width: String,
        val poster_height: String,
        val kgrade_name: String,
        val kgrade_code: String,
        val poster_adult_yn: String,
        val streaming_only_yn: String,
        val reservation: String,
        val preview_url: String,
        val nstore_pc_url: String,
        val mv_id: String,
        val attr_bottom_of_title: String
    ) : Movie() {
        override val title: String
            get() = ktitle
        override val image: String
            get() = poster_img
    }
}
