package com.onekey.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onekey.mymovies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }
}
