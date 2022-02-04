package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentKayitBinding

class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.toolbarKaydetFragment.setTitle(R.string.title_new_item)

        binding.buttonSaveItem.setOnClickListener {
            val todoText = binding.editTextTodoItem.text.toString()
            save(todoText)
        }

        return binding.root
    }

    fun save(todoText: String) {
        Log.e("Save Todo Text", "$todoText")
    }
}