package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.repo.TodoItemDaoRepository

class DetailFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val trepo = TodoItemDaoRepository(application)

    fun update(todoId: Int, todoText: String) {
        trepo.updateTodoItem(todoId, todoText)
    }
}