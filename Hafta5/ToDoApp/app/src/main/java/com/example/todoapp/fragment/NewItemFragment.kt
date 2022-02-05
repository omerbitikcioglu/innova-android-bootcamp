package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentNewItemBinding
import com.example.todoapp.viewmodel.NewItemFragmentViewModel
import com.example.todoapp.viewmodel.NewItemVMF

class NewItemFragment : Fragment() {
    private lateinit var binding: FragmentNewItemBinding
    private lateinit var viewModel: NewItemFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_item, container, false)
        binding.newItemFragment = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NewItemFragmentViewModel by viewModels() {
            NewItemVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun saveNewTodoItem(todoText: String) {
        viewModel.save(todoText)
    }
}