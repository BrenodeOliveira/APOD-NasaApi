package com.example.apod_nasa_api.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.apod_nasa_api.databinding.ActivityMainBinding
import com.example.apod_nasa_api.presentation.adapter.ViewPagerAdapter
import com.example.apod_nasa_api.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupClick()
        setupObservers()

        val fragments: ArrayList<Fragment> = arrayListOf(
            ImageNasaFragment(),
            DescriptionNasaFragment(),
        )

        val adapter = ViewPagerAdapter(fragments, this)
        binding.viewPagerVertical.adapter = adapter
    }

    private fun setupClick() {
        binding.btnGeneratePhoto.setOnClickListener {
            viewModel.generateImage()
        }
    }

    private fun setupObservers() {
        viewModel.loadingState.observe(this) {
            binding.progressCircularBar.isVisible = it
        }
        viewModel.errorMessage.observe(this) {
            binding.textErrorImage.text = it
        }
    }
}