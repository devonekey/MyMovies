package com.onekey.mymovies.viewmodel;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.onekey.mymovies.BR;
import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.data.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MovieViewModel extends BaseObservable {
    private final List<Movie> cache = new ArrayList<>();
    private final ObservableField<List<Movie>> movieList = new ObservableField<>();
    private final ObservableField<String> search = new ObservableField<>();
    private static final String TAG = MovieViewModel.class.getSimpleName();

    public MovieViewModel() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "//run");
                }

                List<Movie> movies = new ArrayList<>();

                movies.add(new Movie("https://media2.giphy.com/media/XZ03Gr7H2TRJYbVgZU/giphy.gif",
                        "Bong Joon Ho Oscars GIF By The Academy Awards"));
                movies.add(new Movie("https://media3.giphy.com/media/UsAZ9QJMpQKoW8yTlF/200.webp",
                        "#oscars #academy awards #oscars 2020"));
                movies.add(new Movie("https://media1.giphy.com/media/fSLaYwsfw8MqrnsCLk/giphy.gif",
                        "Bong Joon Ho Oscars GIF By The Academy Awards"));
                movies.add(new Movie("https://media2.giphy.com/media/XH57VC47wCEnUPqErW/200.webp",
                        "Charlize Theron Oscars GIF By The Academy Awards"));
                movieList.set(movies);
                cache.addAll(movies);
                notifyChange();
            }
        };

        timer.schedule(timerTask, TimeUnit.SECONDS.toMillis(3));
    }

    @Bindable
    @Nullable
    public List<Movie> getMovieList() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/getMovieList");

            if (movieList.get() != null) {
                Log.d(TAG, "/getMovieList" +
                        "\nsize : " + movieList.get().size());
            }
        }

        return movieList.get();
    }

    @Bindable
    public String getSearch() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/getSearch");
        }

        return search.get();
    }

    public void setSearch(String search) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/setSearch" +
                    "\nsearch : " + search);
        }

        this.search.set(search);
        notifyPropertyChanged(BR._all);
    }

    public void onSearchButtonClick() {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onSearchButtonClick");
        }

        if (movieList.get() != null
                && !TextUtils.isEmpty(search.get())) {
            movieList.get().clear();

            for (Movie movie : cache) {
                if (movie.getTitle().contains(search.get())) {
                    movieList.get().add(movie);
                }
            }
        } else if (movieList.get() != null) {
            movieList.get().clear();
            movieList.get().addAll(cache);
        }

        notifyChange();
    }

    public void onItemClick(int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onItemClick" +
                    "\nposition : " + position);
        }
    }
}
