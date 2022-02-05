package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.entity.TodoItem

@Dao
interface TodoItemDao {
    @Query("SELECT * FROM todoItems")
    suspend fun allItems(): List<TodoItem>

    @Insert
    suspend fun addTodo(todoItem: TodoItem)

    @Update
    suspend fun updateTodo(todoItem: TodoItem)

    @Delete
    suspend fun deleteItem(todoItem: TodoItem)

    @Query("SELECT * FROM todoItems WHERE todoText like '%' || :searchText || '%'")
    suspend fun searchItem(searchText: String): List<TodoItem>
}