package com.example.todoapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.TodoItemDaoRepository

class NewItemFragmentViewModel : ViewModel() {
    val trepo = TodoItemDaoRepository()

    fun save(todoText: String) {
        trepo.saveNewTodoItem(todoText)
    }
}