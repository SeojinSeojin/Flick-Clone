package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.R
import org.sopt.flickclone.databinding.FragmentTodoHistoryBinding
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.presentation.base.DataBindingFragment

@AndroidEntryPoint
class TodoHistoryFragment :
    DataBindingFragment<FragmentTodoHistoryBinding>(R.layout.fragment_todo_history) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachEventHandler()
        showTodoList()
    }

    private fun attachEventHandler() {
        binding.btnHistoryMove.setOnClickListener {
            mainViewModel.setCurrentFragmentPage(1)
        }
    }

    private fun showTodoList() {
        val todoAdapter = ToDoAdapter(object : TodoHandler {
            override fun completeTodo(todoData: TodoData) {}

            override fun updateTodo(todoData: TodoData, newContent: String) {
                mainViewModel.updateTodo(todoData, newContent)
            }

            override fun deleteTodo(todoData: TodoData) {
                mainViewModel.deleteTodo(todoData)
            }
        })
        binding.recyclerviewHistory.adapter = todoAdapter
        mainViewModel.historyTodos.observe(viewLifecycleOwner, {
            todoAdapter.setItem(it)
        })
    }
}