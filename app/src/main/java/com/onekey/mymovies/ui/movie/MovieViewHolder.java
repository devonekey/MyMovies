package com.onekey.mymovies.ui.movie;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.data.Movie;
import com.onekey.mymovies.databinding.ViewHolderMovieBinding;
import com.onekey.mymovies.viewmodel.MovieViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private ViewHolderMovieBinding binding;
    private static final String TAG = MovieViewHolder.class.getSimpleName();

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(@NonNull MovieViewModel movieViewModel,
                     int position,
                     Movie movie) {
        binding.setViewModel(movieViewModel);
        binding.setPosition(position);
        binding.setMovie(movie);
    }

    @BindingAdapter("onUrlSet")
    public static void onUrlSet(ImageView imageView,
                                String url) {
        Picasso.get().load(url).into(imageView, new Callback() {
            @Override
            public void onSuccess() {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "//onSuccess");
                }
            }

            @Override
            public void onError(Exception e) {
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "//onError" +
                            "\n" + e);
                }
            }
        });
    }
}
