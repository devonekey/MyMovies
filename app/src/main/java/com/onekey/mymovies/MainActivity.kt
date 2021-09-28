package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.onekey.mymovies.data.source.MoviesRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var repository: MoviesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository.searchMovies(
            onSuccess = {
                Log.d(TAG, "searchMovies, onSuccess")
            },
            onFailure = {
                Log.d(TAG, "searchMovies, onFailure")
            }
        )
        repository.getCurrentlyShowingMovies(
            onSuccess = {
                Log.d(TAG, "getCurrentlyShowingMovies, onSuccess")
            },
            onFailure = {
                Log.d(TAG, "getCurrentlyShowingMovies, onFailure")
            }
        )
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
