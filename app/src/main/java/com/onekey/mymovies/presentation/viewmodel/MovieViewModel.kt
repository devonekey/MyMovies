package com.onekey.mymovies.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.data.source.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    val currentlyShowingMovie: MutableLiveData<Movie?> =
        MutableLiveData<Movie?>()

    fun getCurrentlyShowingMovie(position: Int) {
        moviesRepository.getCurrentlyShowingMovie(
            position,
            onSuccess = { movie ->
                Log.d(TAG, "getCurrentlyShowingMovie, onSuccess")

                currentlyShowingMovie.postValue(movie)
            },
            onFailure = {
                Log.d(TAG, "getCurrentlyShowingMovie, onFailure")
            }
        )
    }

    companion object {
        val TAG: String = MovieViewModel::class.java.simpleName
    }
}
