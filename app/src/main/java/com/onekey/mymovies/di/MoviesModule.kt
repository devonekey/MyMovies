package com.onekey.mymovies.di

import com.onekey.mymovies.data.source.MoviesRepository
import com.onekey.mymovies.presentation.viewmodel.MoviesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MoviesModule {
    @Provides
    fun provideMoviesViewModel(moviesRepository: MoviesRepository): MoviesViewModel =
        MoviesViewModel(moviesRepository = moviesRepository)
}
