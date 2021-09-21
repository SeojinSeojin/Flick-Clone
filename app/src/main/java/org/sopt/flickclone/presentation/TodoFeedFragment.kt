package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.R
import org.sopt.flickclone.databinding.FragmentTodoFeedBinding
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.presentation.base.DataBindingFragment

@AndroidEntryPoint
class TodoFeedFragment :
    DataBindingFragment<FragmentTodoFeedBinding>(R.layout.fragment_todo_feed) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = mainViewModel
        attachEventHandler()
        attachTextWatcher()
        attachOnclickListener()
        showTodoList()
    }

    private fun attachEventHandler() {
        binding.btnFeedMove.setOnClickListener {
            mainViewModel.setCurrentFragmentPage(0)
        }
    }

    private fun attachTextWatcher() {
        binding.edittextFeed.doAfterTextChanged {
            binding.btnFeedCreate.isActivated = it?.isNotEmpty() == true
        }
    }

    private fun attachOnclickListener() {
        binding.btnFeedCreate.setOnClickListener {
            mainViewModel.createTodo()
        }
    }

    private fun showTodoList() {
        val todoAdapter = ToDoAdapter(object : TodoHandler {
            override fun completeTodo(todoData: TodoData) {
                mainViewModel.completeTodo(todoData)
            }

            override fun updateTodo(todoData: TodoData, newContent: String) {
                mainViewModel.updateTodo(todoData, newContent)
            }

            override fun deleteTodo(todoData: TodoData) {
                mainViewModel.deleteTodo(todoData)
            }
        })
        binding.recyclerviewFeed.adapter = todoAdapter
        mainViewModel.feedTodos.observe(viewLifecycleOwner, {
            todoAdapter.setItem(it)
        })
    }

}