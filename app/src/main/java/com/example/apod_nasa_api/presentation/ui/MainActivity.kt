package com.example.apod_nasa_api.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.apod_nasa_api.R
import com.example.apod_nasa_api.databinding.ActivityMainBinding
import com.example.apod_nasa_api.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        setupClick()
        setupObservers()
    }

    private fun setupClick() {
        binding.btnGeneratePhoto.setOnClickListener {
            viewModel.generateImage()
        }
    }

    private fun setupObservers() {
        viewModel.imageGenerated.observe(this) {
            Glide.with(this)
                .load(it)
                .into(binding.imagePhotoGenerated)
            /**
             * Colocar a descrição da foto ao lado
             */
        }
    }
}