package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.repo.TodoItemDaoRepository

class NewItemFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val trepo = TodoItemDaoRepository(application)

    fun save(todoText: String) {
        trepo.addNewTodoItem(todoText)
    }
}