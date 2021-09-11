package org.sopt.flickclone.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
    @Inject
    lateinit var todoDao: TodoDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = mainViewModel
        attachEventHandler()
        attachTextWatcher()
        attachOnclickListener()
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
        val textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                binding.btnFeedCreate.isActivated = s.isNotEmpty()
            }
        }
        binding.edittextFeed.addTextChangedListener(textWatcher)
    }

    private fun attachOnclickListener() {
        binding.btnFeedCreate.setOnClickListener {
            mainViewModel.createTodo()
        }
    }

}