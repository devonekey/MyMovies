package com.onekey.mymovies.data.source

import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.data.source.remote.MoviesRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesDataSource {
    private var currentlyShowingMovies: List<Movie?>? = null

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
        moviesRemoteDataSource.getCurrentlyShowingMovies(
            onSuccess = { movies ->
                currentlyShowingMovies = movies

                onSuccess.invoke(currentlyShowingMovies)
            },
            onFailure
        )
    }

    override fun getCurrentlyShowingMovie(
        position: Int,
        onSuccess: (Movie?) -> Unit,
        onFailure: (String?) -> Unit
    ) {
        currentlyShowingMovies?.getOrNull(position)
            ?.run { onSuccess.invoke(this) }
            ?: onFailure.invoke("getCurrentlyShowingMovie, onFailure invoked")
    }
}
