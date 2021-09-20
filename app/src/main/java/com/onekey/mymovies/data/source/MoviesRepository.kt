package com.onekey.mymovies.data.source

import com.onekey.mymovies.data.Movie

class MoviesRepository(
    private val moviesRemoteDataSource: MoviesDataSource
) : MoviesDataSource {
    override fun searchMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    ) {
        moviesRemoteDataSource.searchMovies(onSuccess, onFailure)
    }

    override fun getCurrentlyShowingMovies(
        onSuccess: ((List<Movie?>?) -> Unit),
        onFailure: ((String?) -> Unit)
    ) {
        moviesRemoteDataSource.getCurrentlyShowingMovies(onSuccess, onFailure)
    }
}
