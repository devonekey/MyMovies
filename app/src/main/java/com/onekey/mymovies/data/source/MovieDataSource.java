package com.onekey.mymovies.data.source;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.onekey.mymovies.data.Movie;

import java.util.List;

public interface MovieDataSource {
    @FunctionalInterface
    interface OnBrowseSuccessListener {
        void onSuccess(@NonNull List<Movie> movieList);
    }

    @FunctionalInterface
    interface OnBrowsingListener {
        void onProcessing();
    }

    @FunctionalInterface
    interface OnBroseFailureListener {
        void onFailure();
    }

    void browse(@NonNull OnBrowseSuccessListener onBrowseSuccessListener,
                @Nullable OnBrowsingListener onBrowsingListener,
                @Nullable OnBroseFailureListener onBroseFailureListener);

    @FunctionalInterface
    interface OnReadSuccessListener {
        void onSuccess(@NonNull Movie movie);
    }

    @FunctionalInterface
    interface OnReadingListener {
        void onReading();
    }

    @FunctionalInterface
    interface OnReadFailureListener {
        void onFailure();
    }

    void read(int id,
              int position,
              @NonNull OnReadSuccessListener onReadSuccessListener,
              @Nullable OnReadingListener onReadingListener,
              @Nullable OnReadFailureListener onReadFailureListener);

    @FunctionalInterface
    interface OnEditSuccessListener {
        void onSuccess();
    }

    @FunctionalInterface
    interface OnEditingListener {
        void onProcessing();
    }

    @FunctionalInterface
    interface OnEditFailureListener {
        void onFailure();
    }

    void edit(int id,
              @NonNull Movie movie,
              @NonNull OnEditSuccessListener onEditSuccessListener,
              @Nullable OnEditingListener onEditingListener,
              @Nullable OnEditFailureListener onEditFailureListener);

    @FunctionalInterface
    interface OnAddSuccessListener {
        void onSuccess();
    }

    @FunctionalInterface
    interface OnAddingListener {
        void onProcessing();
    }

    @FunctionalInterface
    interface OnAddFailureListener {
        void onFailure();
    }

    void add(@NonNull Movie movie,
             @NonNull OnAddSuccessListener onAddSuccessListener,
             @Nullable OnAddingListener onAddingListener,
             @Nullable OnAddFailureListener onAddFailureListener);

    @FunctionalInterface
    interface OnDeleteSuccessListener {
        void onSuccess();
    }

    @FunctionalInterface
    interface OnDeletingListener {
        void onProcessing();
    }

    @FunctionalInterface
    interface OnDeleteFailureListener {
        void onFailure();
    }

    void delete(int id,
                @NonNull OnDeleteSuccessListener onDeleteSuccessListener,
                @Nullable OnDeletingListener onDeletingListener,
                @Nullable OnDeleteFailureListener onDeleteFailureListener);
}
