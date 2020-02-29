package com.onekey.mymovies.data.source;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.data.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDataRepository implements MovieDataSource {
    private static MovieDataRepository movieDataRepository;
    private final MovieDataSource movieLocalDataSource;
    private static List<Movie> cache;
    private static final String TAG = MovieDataRepository.class.getSimpleName();

    private MovieDataRepository(@NonNull MovieDataSource movieLocalDataSource) {
        this.movieLocalDataSource = movieLocalDataSource;
        cache = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("https://media2.giphy.com/media/XZ03Gr7H2TRJYbVgZU/giphy.gif",
                "Bong Joon Ho Oscars GIF By The Academy Awards"));
        movies.add(new Movie("https://media3.giphy.com/media/UsAZ9QJMpQKoW8yTlF/200.webp",
                "#oscars #academy awards #oscars 2020"));
        movies.add(new Movie("https://media1.giphy.com/media/fSLaYwsfw8MqrnsCLk/giphy.gif",
                "Bong Joon Ho Oscars GIF By The Academy Awards"));
        movies.add(new Movie("https://media2.giphy.com/media/XH57VC47wCEnUPqErW/200.webp",
                "Charlize Theron Oscars GIF By The Academy Awards"));
        cache.addAll(movies);
    }

    public static MovieDataRepository getInstance(@NonNull MovieDataSource movieLocalDataSource) {
        if (movieDataRepository == null) {
            movieDataRepository = new MovieDataRepository(movieLocalDataSource);
        }

        return movieDataRepository;
    }

    @Override
    public void browse(@NonNull OnBrowseSuccessListener onBrowseSuccessListener,
                       @Nullable OnBrowsingListener onBrowsingListener,
                       @Nullable OnBroseFailureListener onBroseFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/browse");
        }

        onBrowseSuccessListener.onSuccess(cache);
    }

    @Override
    public void read(int id,
                     int position,
                     @NonNull OnReadSuccessListener onReadSuccessListener,
                     @Nullable OnReadingListener onReadingListener,
                     @Nullable OnReadFailureListener onReadFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/read");
        }
    }

    @Override
    public void edit(int id,
                     @NonNull Movie movie,
                     @NonNull OnEditSuccessListener onEditSuccessListener,
                     @Nullable OnEditingListener onEditingListener,
                     @Nullable OnEditFailureListener onEditFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/edit");
        }
    }

    @Override
    public void add(@NonNull Movie movie,
                    @NonNull OnAddSuccessListener onAddSuccessListener,
                    @Nullable OnAddingListener onAddingListener,
                    @Nullable OnAddFailureListener onAddFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/add");
        }
    }

    @Override
    public void delete(int id,
                       @NonNull OnDeleteSuccessListener onDeleteSuccessListener,
                       @Nullable OnDeletingListener onDeletingListener,
                       @Nullable OnDeleteFailureListener onDeleteFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/delete");
        }
    }
}
