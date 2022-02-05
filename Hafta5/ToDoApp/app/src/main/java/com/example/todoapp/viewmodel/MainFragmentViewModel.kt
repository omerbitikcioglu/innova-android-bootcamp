package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.repo.TodoItemDaoRepository

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var todoItems = MutableLiveData<List<TodoItem>>()
    val trepo = TodoItemDaoRepository(application)

    init {
        loadTodoItems()
        todoItems = trepo.getTodoItemList()
    }

    fun search(searchText: String) {
        trepo.searchTodoItem(searchText)
    }

    fun delete(todoId: Int) {
        trepo.deleteTodoItem(todoId)
    }

    fun loadTodoItems() {
        trepo.fetchAllTodoItems()
    }
}