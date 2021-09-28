package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.mymovies.databinding.ActivityMainBinding
import com.onekey.mymovies.presentation.view.MoviesAdapter
import com.onekey.mymovies.presentation.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var viewModel: MoviesViewModel
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
        viewModel.currentlyShowingMovies
            .observe(
                this,
                { movies -> adapter.addAll(movies) }
            )
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
