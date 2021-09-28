package com.onekey.mymovies.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.mymovies.databinding.FragmentMainBinding
import com.onekey.mymovies.presentation.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {
    @Inject lateinit var viewModel: MoviesViewModel
    private lateinit var binding: FragmentMainBinding
    private val adapter by lazy { MoviesAdapter(viewModel) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.moviesRecyclerView
            .apply {
                layoutManager = LinearLayoutManager(
                    container?.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                adapter = this@MainFragment.adapter
            }
        viewModel.currentlyShowingMovies
            .observe(
                requireActivity(),
                { adapter.notifyDataSetChanged() }
            )

        return binding.root
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}
