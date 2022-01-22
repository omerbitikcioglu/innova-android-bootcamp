package com.example.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationsample.databinding.FragmentSayfaXBinding

class SayfaXFragment : Fragment() {
    private lateinit var binding: FragmentSayfaXBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSayfaXBinding.inflate(inflater, container, false)

        binding.buttonGoY2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_sayfaXFragment_to_sayfaYFragment)
        }

        return binding.root
    }
}