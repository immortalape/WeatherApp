package com.example.weatherapp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R
import com.example.weatherapp.databinding.HomeFragmentBinding
class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = HomeFragmentBinding.inflate(inflater, container, false)

        viewModel.oneCall(38.5598, 68.7870).observe(viewLifecycleOwner, { data ->
            Log.d("debug", "onCreateView: $data")
            val temp = data.current.temp-273.15
            binding.temperatureTextView.text = temp.toString()
            binding.realTextView.text = data.current.weather[0].description
        })

        return binding.root
    }

}

