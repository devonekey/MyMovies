package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.mymovies.data.source.MoviesRepository
import com.onekey.mymovies.databinding.ActivityMainBinding
import com.onekey.mymovies.presentation.view.MoviesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var repository: MoviesRepository
    private lateinit var binding: ActivityMainBinding
    private val adapter = MoviesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.moviesRecyclerView
            .apply {
                layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = this@MainActivity.adapter
            }
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

                adapter.addAll(it)
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
