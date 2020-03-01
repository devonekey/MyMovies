package com.onekey.mymovies.ui.movie;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.R;
import com.onekey.mymovies.databinding.ActivityMainBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private final ActivityMainBinding binding;
    private static final String TAG = MovieAdapter.class.getSimpleName();

    public MovieAdapter(View root) {
        binding = DataBindingUtil.getBinding(root);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                              int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder,
                                 int position) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onBindViewHolder" +
                    "\nposition : " + position +
                    "\nholder position : " + holder.getAdapterPosition());
        }

        holder.bind(binding.getViewModel(),
                holder.getAdapterPosition(),
                binding.getViewModel().getMovieList().get(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        int size = binding.getViewModel().getMovieList() != null ?
                binding.getViewModel().getMovieList().size() : 0;

        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/getItemCount" +
                    "\nsize : " + size);
        }
 ;
        return size;
    }
}
