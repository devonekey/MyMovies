package com.onekey.mymovies.data.source.local;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.data.Movie;
import com.onekey.mymovies.data.source.MovieDataSource;

public class MovieLocalDataSource implements MovieDataSource {
    private static MovieLocalDataSource movieLocalDataSource;
//    private final MovieDatabaseOpenHelper prefDatabaseOpenHelper;
    private static final String TAG = MovieLocalDataSource.class.getSimpleName();

    private MovieLocalDataSource(@NonNull Context context) {
//        prefDatabaseOpenHelper = MovieDatabaseOpenHelper.getInstance(context);
    }

    public static MovieLocalDataSource getInstance(@NonNull Context context) {
        if (movieLocalDataSource == null) {
            movieLocalDataSource = new MovieLocalDataSource(context);
        }

        return movieLocalDataSource;
    }

    @Override
    public void browse(@NonNull OnBrowseSuccessListener onBrowseSuccessListener,
                       @Nullable OnBrowsingListener onBrowsingListener,
                       @Nullable OnBroseFailureListener onBroseFailureListener) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/browse");
        }
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
