package org.sopt.flickclone.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.R
import org.sopt.flickclone.databinding.FragmentTodoFeedBinding
import org.sopt.flickclone.persistance.TodoDao
import org.sopt.flickclone.presentation.base.DataBindingFragment
import javax.inject.Inject

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
            (requireActivity() as MainActivity).swipeFragment(
                0,
                true
            )
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
        val todoAdapter =
            ToDoAdapter({ todo -> mainViewModel.completeTodo(todo) },
                { todo, string -> mainViewModel.updateTodo(todo, string) },
                { todo -> mainViewModel.deleteTodo(todo) })
        binding.recyclerviewFeed.adapter = todoAdapter
        mainViewModel.feedTodos.observe(viewLifecycleOwner, {
            todoAdapter.setItem(it)
        })
    }

}