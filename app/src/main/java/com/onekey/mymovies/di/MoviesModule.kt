package com.onekey.mymovies.di

import com.onekey.mymovies.data.source.MoviesRepository
import com.onekey.mymovies.data.source.remote.MoviesRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MoviesModule {
    @Provides
    fun provideMoviesRemoteDataSource(): MoviesRemoteDataSource =
        MoviesRemoteDataSource()

    @Provides
    fun provideMoviesRepository(moviesRemoteDataSource: MoviesRemoteDataSource): MoviesRepository =
        MoviesRepository(moviesRemoteDataSource = moviesRemoteDataSource)
}
