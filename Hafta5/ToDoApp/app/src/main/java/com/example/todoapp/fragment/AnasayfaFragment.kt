package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.TodoItemAdapter
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.entity.TodoItem

class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var adapter: TodoItemAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.toolbarMainFragment.setTitle(R.string.title_main)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainFragment)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val todoList = ArrayList<TodoItem>()
        val todo1 = TodoItem(1, "Ekmek al")
        val todo2 = TodoItem(2, "Çöpü boşalt")
        val todo3 = TodoItem(3, "Köpeği gezdir")
        val todo4 = TodoItem(4, "Ödevi yap")
        val todo5 = TodoItem(5, "Kitap oku")
        todoList.add(todo1)
        todoList.add(todo2)
        todoList.add(todo3)
        todoList.add(todo4)
        todoList.add(todo5)

        adapter = TodoItemAdapter(requireContext(), todoList)
        binding.rv.adapter = adapter

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfaFragment_to_kayitFragment)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchText: String) {
        Log.e("Search Item", searchText)
    }
}