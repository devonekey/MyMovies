package com.onekey.mymovies.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.onekey.mymovies.BuildConfig;
import com.onekey.mymovies.R;
import com.onekey.mymovies.data.Movie;
import com.onekey.mymovies.databinding.ActivityMainBinding;
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
    }

    @BindingAdapter("onListSet")
    public static void onListSet(RecyclerView recyclerView,
                                 List<Movie> list) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "/onListSet" +
                    "\nlist is null ? " + (list == null));

            if ((list != null)) {
                Log.d(TAG, "/onListSet" +
                        "\nsize : " + list.size());
            }
        }

        if (recyclerView.getAdapter() != null) {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
