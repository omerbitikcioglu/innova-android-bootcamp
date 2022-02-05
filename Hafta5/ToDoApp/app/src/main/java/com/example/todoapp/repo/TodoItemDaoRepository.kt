package com.example.todoapp.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.TodoItem

class TodoItemDaoRepository {
    var todoItems: MutableLiveData<List<TodoItem>>

    init {
        todoItems = MutableLiveData()
    }

    fun getTodoItemList() : MutableLiveData<List<TodoItem>> {
        return todoItems
    }

    fun saveNewTodoItem(todoText: String) {
        Log.e("Save Todo Text", todoText)
    }

    fun updateTodoItem(todoId: Int, todoText: String) {
        Log.e("Update Todo Item", "$todoId - $todoText")
    }

    fun searchTodoItem(searchText: String) {
        Log.e("Search Item", searchText)
    }

    fun deleteTodoItem(todoId: Int) {
        Log.e("Delete item", todoId.toString())
    }

    fun fetchTodoItems() {
        val items = ArrayList<TodoItem>()
        val todo1 = TodoItem(1, "Ekmek al")
        val todo2 = TodoItem(2, "Çöpü boşalt")
        val todo3 = TodoItem(3, "Köpeği gezdir")
        val todo4 = TodoItem(4, "Ödevi yap")
        val todo5 = TodoItem(5, "Kitap oku")
        items.add(todo1)
        items.add(todo2)
        items.add(todo3)
        items.add(todo4)
        items.add(todo5)
        todoItems.value = items
    }
}