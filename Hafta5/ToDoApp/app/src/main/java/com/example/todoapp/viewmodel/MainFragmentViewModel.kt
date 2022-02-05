package com.example.todoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.repo.TodoItemDaoRepository

class MainFragmentViewModel : ViewModel() {
    var todoItems = MutableLiveData<List<TodoItem>>()
    val trepo = TodoItemDaoRepository()

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
        trepo.fetchTodoItems()
    }
}