package com.example.apod_nasa_api.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.apod_nasa_api.R
import com.example.apod_nasa_api.databinding.ActivityMainBinding
import com.example.apod_nasa_api.presentation.HorizontalMarginItemDecoration
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
        setupCarousel()
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
             * viewPager
             */
        }
        viewModel.loadingState.observe(this) {
            binding.progressCircularBar.isVisible = it
        }
        viewModel.errorMessage.observe(this) {
            binding.textErrorImage.text = it
        }
    }

    /**
     * Colocar um model dentro de um cardView com: ImageView, TextView com as labels de titulo e etc
     */

    private fun setupCarousel(){
        binding.viewPagerVertical.offscreenPageLimit = 1

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        binding.viewPagerVertical.setPageTransformer(pageTransformer)
        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPagerVertical.addItemDecoration(itemDecoration)
    }
}