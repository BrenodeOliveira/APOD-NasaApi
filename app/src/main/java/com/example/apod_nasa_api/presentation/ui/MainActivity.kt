package com.example.apod_nasa_api.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apod_nasa_api.R
import com.example.apod_nasa_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnGeneratePhoto.setOnClickListener {
            Toast.makeText(this, "botao", Toast.LENGTH_SHORT).show()
        }
    }
}