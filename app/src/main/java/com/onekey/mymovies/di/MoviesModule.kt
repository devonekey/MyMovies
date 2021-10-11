package com.onekey.mymovies.di

import com.onekey.mymovies.data.source.MoviesRepository
import com.onekey.mymovies.presentation.viewmodel.MovieViewModel
import com.onekey.mymovies.presentation.viewmodel.MoviesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object MoviesModule {
    @Provides
    fun provideMoviesViewModel(moviesRepository: MoviesRepository): MoviesViewModel =
        MoviesViewModel(moviesRepository = moviesRepository)

    @Provides
    fun provideMovieViewModel(moviesRepository: MoviesRepository): MovieViewModel =
        MovieViewModel(moviesRepository = moviesRepository)
}
