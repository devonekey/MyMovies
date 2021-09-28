package com.onekey.mymovies.data.source

import com.onekey.mymovies.data.Movie

interface MoviesDataSource {
    fun searchMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    )

    fun getCurrentlyShowingMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    )
}
