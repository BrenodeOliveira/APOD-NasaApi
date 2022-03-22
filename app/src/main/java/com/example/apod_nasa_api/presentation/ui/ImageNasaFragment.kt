package com.example.apod_nasa_api.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.apod_nasa_api.R
import com.example.apod_nasa_api.databinding.FragmentImageNasaBinding
import com.example.apod_nasa_api.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ImageNasaFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var imageNasaBinding: FragmentImageNasaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentImageNasaBinding.inflate(layoutInflater).also {
            imageNasaBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dataGenerated.observe(viewLifecycleOwner) {
            Glide.with(this)
                .load(it.hdurl)
                .into(imageNasaBinding.imgModelPager)
        }
    }
}