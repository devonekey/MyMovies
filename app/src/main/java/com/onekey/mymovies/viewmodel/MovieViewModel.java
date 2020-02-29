package com.onekey.mymovies.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.onekey.mymovies.BR;
import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.data.Movie;
import com.onekey.mymovies.data.source.MovieDataRepository;
import com.onekey.mymovies.data.source.MovieDataSource;
import com.onekey.mymovies.data.source.local.MovieLocalDataSource;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MovieViewModel extends BaseObservable {
    private final MovieDataRepository movieDataRepository;
    private final ObservableArrayList<Movie> movieObservableArrayList = new ObservableArrayList<>();
    private final ObservableField<String> search = new ObservableField<>();
    private static final int WAITING_TIME = 3;
    private static final int FIRST_INDEX = 0;
    private static final String TAG = MovieViewModel.class.getSimpleName();

    public MovieViewModel(@NonNull Context context) {
        movieDataRepository = MovieDataRepository.getInstance(MovieLocalDataSource
                .getInstance(context));
        movieDataRepository.browse(new MovieDataSource.OnBrowseSuccessListener() {
            @Override
            public void onSuccess(@NonNull final List<Movie> movieList) {
                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        if (BuildConfig.DEBUG) {
                            Log.d(TAG, "//run");
                        }

                        movieObservableArrayList.addAll(movieList);
                        notifyChange();
                    }
                };

                timer.schedule(timerTask, TimeUnit.SECONDS.toMillis(WAITING_TIME));
            }
        }, null, null);
    }

    @Bindable
    @Nullable
    public List<Movie> getMovieList() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/getMovieList" +
                    "\nsize : " + movieObservableArrayList.size());
        }

        return movieObservableArrayList.size() > 0 ?
                movieObservableArrayList.subList(FIRST_INDEX, movieObservableArrayList.size() - 1) :
                null;
    }

    @Bindable
    public String getSearch() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/getSearch");
        }

        return search.get();
    }

    public void setSearch(final String search) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/setSearch" +
                    "\nsearch : " + search);
        }

        if (movieObservableArrayList.size() > 0
                && !TextUtils.isEmpty(search)) {
            movieObservableArrayList.subList(FIRST_INDEX, movieObservableArrayList.size() - 1)
                    .clear();

            movieDataRepository.browse(new MovieDataSource.OnBrowseSuccessListener() {
                @Override
                public void onSuccess(@NonNull List<Movie> movieList) {
                    for (Movie movie : movieList) {
                        if (movie.getTitle().contains(search)) {
                            movieObservableArrayList.add(movie);
                            notifyPropertyChanged(BR._all);
                        }
                    }
                }
            }, null, null);
        } else if (movieObservableArrayList.size() > 0) {
            movieObservableArrayList.subList(FIRST_INDEX, movieObservableArrayList.size() - 1)
                    .clear();

            movieDataRepository.browse(new MovieDataSource.OnBrowseSuccessListener() {
                @Override
                public void onSuccess(@NonNull List<Movie> movieList) {
                    movieObservableArrayList.addAll(movieList);
                    notifyPropertyChanged(BR._all);
                }
            }, null, null);
        }

        this.search.set(search);
        notifyPropertyChanged(BR._all);
    }

    public void onSearchButtonClick() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onSearchButtonClick");
        }
    }

    public void onItemClick(int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onItemClick" +
                    "\nposition : " + position);
        }
    }
}
