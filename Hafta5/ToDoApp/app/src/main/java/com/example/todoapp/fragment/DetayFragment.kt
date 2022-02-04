package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        binding.toolbarDetayFragment.setTitle(R.string.title_detail)

        val bundle: DetayFragmentArgs by navArgs()
        val sentTodoItem = bundle.todoItem

        binding.editTextTodoItem.setText(sentTodoItem.todoText)

        binding.buttonUpdate.setOnClickListener {
            val newTodoText = binding.editTextTodoItem.text.toString()
            updateTodoItem(sentTodoItem.todoId, newTodoText)
        }

        return binding.root
    }

    fun updateTodoItem(todoId: Int, todoText: String) {
        Log.e("Update Todo Item", "$todoId - $todoText")
    }
}