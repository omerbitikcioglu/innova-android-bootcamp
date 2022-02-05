package com.example.todoapp.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.room.TodoDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoItemDaoRepository(var application: Application) {
    var todoItems: MutableLiveData<List<TodoItem>>
    var db: TodoDatabase

    init {
        todoItems = MutableLiveData()
        db = TodoDatabase.databaseAccess(application)!!
    }

    fun getTodoItemList() : MutableLiveData<List<TodoItem>> {
        return todoItems
    }

    fun addNewTodoItem(todoText: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newTodoItem = TodoItem(0, todoText)
            db.todoItemDao().addTodo(newTodoItem)
        }
    }

    fun updateTodoItem(todoId: Int, todoText: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedTodoItem = TodoItem(todoId, todoText)
            db.todoItemDao().updateTodo(updatedTodoItem)
        }
    }

    fun searchTodoItem(searchText: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            todoItems.value = db.todoItemDao().searchItem(searchText)
        }
    }

    fun deleteTodoItem(todoId: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val removedTodoItem = TodoItem(todoId, "")
            db.todoItemDao().deleteItem(removedTodoItem)
            fetchAllTodoItems()
        }
    }

    fun fetchAllTodoItems() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            todoItems.value = db.todoItemDao().allItems()
        }
    }
}