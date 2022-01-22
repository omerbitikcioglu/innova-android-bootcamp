package com.example.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationsample.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding : FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.buttonA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_sayfaAFragment)
        }

        binding.buttonX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_sayfaXFragment)
        }

        return binding.root
    }
}