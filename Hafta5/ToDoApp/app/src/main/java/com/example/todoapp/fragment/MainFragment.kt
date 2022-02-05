package com.example.todoapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.adapter.TodoItemAdapter
import com.example.todoapp.databinding.FragmentMainBinding
import com.example.todoapp.entity.TodoItem
import com.example.todoapp.viewmodel.MainFragmentViewModel

class MainFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: TodoItemAdapter
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.mainFragment = this

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMainFragment)

        viewModel.todoItems.observe(viewLifecycleOwner, {
            adapter = TodoItemAdapter(requireContext(), it, viewModel)
            binding.todoItemAdapter = adapter
        })

        return binding.root
    }

    fun clickFab(v: View) {
        Navigation.findNavController(v).navigate(R.id.action_anasayfaFragment_to_kayitFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }
}