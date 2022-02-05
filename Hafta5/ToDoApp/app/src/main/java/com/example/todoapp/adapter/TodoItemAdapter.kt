package com.example.todoapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TodoItemDesignBinding
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.fragment.MainFragmentDirections
import com.example.todoapp.viewmodel.MainFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class TodoItemAdapter(
    var mContext: Context,
    var todoList: List<TodoItem>,
    var viewModel: MainFragmentViewModel
) :
    RecyclerView.Adapter<TodoItemAdapter.TodoItemHolder>() {

    inner class TodoItemHolder(todoItemDesignBinding: TodoItemDesignBinding) :
        RecyclerView.ViewHolder(todoItemDesignBinding.root) {
        val todoItemDesignBinding: TodoItemDesignBinding

        init {
            this.todoItemDesignBinding = todoItemDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = TodoItemDesignBinding.inflate(layoutInflater, parent, false)
        return TodoItemHolder(design)
    }

    override fun onBindViewHolder(holder: TodoItemHolder, position: Int) {
        val todoItem = todoList.get(position)
        val d = holder.todoItemDesignBinding
        d.todoItem = todoItem

        d.textViewTodoItem.setText(todoItem.todoText)

        d.cardTodoItem.setOnClickListener {
            val nav = MainFragmentDirections.actionAnasayfaFragmentToDetayFragment(todoItem)
            Navigation.findNavController(it).navigate(nav)
        }

        d.imageViewDelete.setOnClickListener {
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