package com.example.apod_nasa_api.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apod_nasa_api.databinding.FragmentDescriptionNasaBinding
import com.example.apod_nasa_api.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DescriptionNasaFragment : Fragment() {

    private val viewModel: MainViewModel by sharedViewModel()
    private lateinit var descriptionNasaFragment: FragmentDescriptionNasaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDescriptionNasaBinding.inflate(layoutInflater).also {
            descriptionNasaFragment = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dataGenerated.observe(viewLifecycleOwner) {
            with(descriptionNasaFragment) {
                textExplanationImage.text = it.explanation
                textTitleImage.text = it.title
                textDateImage.text = it.date
                textAuthImage.text = it.copyright
            }
        }
    }
}