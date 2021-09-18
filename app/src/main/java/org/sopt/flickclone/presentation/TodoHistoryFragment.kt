package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.R
import org.sopt.flickclone.databinding.FragmentTodoHistoryBinding
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
        val todoAdapter = ToDoAdapter({ _ -> },
            { _, _ -> },
            { _ -> })
        binding.recyclerviewHistory.adapter = todoAdapter
        mainViewModel.historyTodos.observe(viewLifecycleOwner, {
            todoAdapter.setItem(it)
        })
    }
}