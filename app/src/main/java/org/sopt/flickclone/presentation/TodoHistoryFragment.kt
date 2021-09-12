package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.presentation.base.ViewBindingFragment
import org.sopt.flickclone.databinding.FragmentTodoHistoryBinding
import org.sopt.flickclone.persistance.TodoDao
import javax.inject.Inject

@AndroidEntryPoint
class TodoHistoryFragment : ViewBindingFragment<FragmentTodoHistoryBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTodoHistoryBinding {
        return FragmentTodoHistoryBinding.inflate(inflater, container, false)
    }

    private val mainViewModel by activityViewModels<MainViewModel>()

    @Inject
    lateinit var todoDao: TodoDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachEventHandler()
        showTodoList()
    }

    private fun attachEventHandler() {
        binding.btnHistoryMove.setOnClickListener {
            (requireActivity() as MainActivity).swipeFragment(
                1,
                true
            )
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