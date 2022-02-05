package com.example.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todoItems")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "todoId") @NotNull var todoId: Int,
    @ColumnInfo(name = "todoText") @NotNull var todoText: String
) : Serializable {

}
