package com.example.todoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class TodoItemAdapter(var mContext: Context, var todoList: List<TodoItem>) :
    RecyclerView.Adapter<TodoItemAdapter.TodoItemHolder>() {

    inner class TodoItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var card_todo_item: CardView
        var textViewTodoText: TextView
        var imageViewDelete: ImageView

        init {
            card_todo_item = view.findViewById(R.id.card_todo_item)
            textViewTodoText = view.findViewById(R.id.textViewTodoItem)
            imageViewDelete = view.findViewById(R.id.imageViewDelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.todo_item, parent,false)
        return TodoItemHolder(design)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {
        val todoItem = todoList.get(position)

        holder.textViewTodoText.setText(todoItem.todoText)

        holder.card_todo_item.setOnClickListener {
            val nav = AnasayfaFragmentDirections.actionAnasayfaFragmentToDetayFragment(todoItem)
            Navigation.findNavController(it).navigate(nav)
        }

        holder.imageViewDelete.setOnClickListener {
            Snackbar.make(it, "${todoItem.todoId}. öğe silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {
                    Log.e("Delete item", todoItem.todoId.toString())
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}