package com.example.recyclerviewtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewtest.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        binding.rv.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        val flowerList = ArrayList<Flowers>()
        val f1 = Flowers(
            1,
            "cicek3",
            "Paşabahçe Vazoda Lilyum\nAranjmanı",
            "129,00",
            4.3f,
            28222,
            "25,15"
        )
        val f2 = Flowers(
            2,
            "cicek4",
            "Doğal Ahşap Kütükte\nPapatya Aranjmanı",
            "99,99",
            4.5f,
            25875,
            "19,49"
        )
        val f3 = Flowers(
            3,
            "cicek5",
            "Paşabahçe Akvaryum\nVazoda 7'li Beyaz Gül Ara...",
            "119,00",
            4.3f,
            3094,
            "23,20"
        )
        val f4 = Flowers(
            4,
            "cicek1",
            "Paşabahçe Cam Vazoda\nPembe ve Beyaz Ada Kar...",
            "109,00",
            3.9f,
            1311,
            "21,25"
        )
        val f5 = Flowers(
            5,
            "cicek2",
            "Doğal Ahşap Kütükte\nRenkli Papatya Aranjmanı",
            "99,99",
            4.4f,
            13875,
            "19,49"
        )
        flowerList.add(f1)
        flowerList.add(f2)
        flowerList.add(f3)
        flowerList.add(f4)
        flowerList.add(f5)

        val adapter = FlowersAdapter(requireContext(), flowerList)
        binding.rv.adapter = adapter

        return binding.root
    }
}