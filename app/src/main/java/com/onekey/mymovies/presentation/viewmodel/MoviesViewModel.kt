package com.onekey.mymovies.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onekey.mymovies.data.Movie
import com.onekey.mymovies.data.source.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    val currentlyShowingMovies: MutableLiveData<List<Movie?>> =
        MutableLiveData<List<Movie?>>().run {
            moviesRepository.getCurrentlyShowingMovies(
                onSuccess = { movies ->
                    Log.d(TAG, "getCurrentlyShowingMovies, onSuccess")

                    postValue(movies)
                },
                onFailure = {
                    Log.d(TAG, "getCurrentlyShowingMovies, onFailure")
                }
            )

            this
        }

    companion object {
        val TAG: String = MoviesViewModel::class.java.simpleName
    }
}
