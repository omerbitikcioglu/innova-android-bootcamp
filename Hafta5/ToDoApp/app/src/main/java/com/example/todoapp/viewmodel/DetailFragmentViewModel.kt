package com.example.todoapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.repo.TodoItemDaoRepository

class DetailFragmentViewModel : ViewModel() {
    val trepo = TodoItemDaoRepository()

    fun update(todoId: Int, todoText: String) {
        trepo.updateTodoItem(todoId, todoText)
    }
}