package com.onekey.mymovies.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.R;
import com.onekey.mymovies.data.Movie;
import com.onekey.mymovies.databinding.ActivityMainBinding;
import com.onekey.mymovies.ui.movie.EditMovieActivity;
import com.onekey.mymovies.ui.movie.MovieAdapter;
import com.onekey.mymovies.viewmodel.MovieViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        MovieViewModel model = new MovieViewModel(MainActivity.this);
        MovieAdapter adapter = new MovieAdapter(binding.getRoot());

        binding.activityMainMovieRecyclerView.setLayoutManager(new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.activityMainMovieRecyclerView.setAdapter(adapter);
        binding.setViewModel(model);
        binding.activityMainFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EditMovieActivity.class));
            }
        });
    }

    @BindingAdapter("onListSet")
    public static void onListSet(@NonNull RecyclerView recyclerView,
                                 @Nullable List<Movie> list) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onListSet" +
                    "\nsize ? " + (list == null ? "null" : list.size()));
        }

        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
