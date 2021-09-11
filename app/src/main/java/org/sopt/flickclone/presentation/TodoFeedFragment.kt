package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.R
import org.sopt.flickclone.databinding.FragmentTodoFeedBinding
import org.sopt.flickclone.persistance.TodoDao
import org.sopt.flickclone.presentation.base.DataBindingFragment
import javax.inject.Inject

@AndroidEntryPoint
class TodoFeedFragment : DataBindingFragment<FragmentTodoFeedBinding>(R.layout.fragment_todo_feed) {

    @Inject
    lateinit var todoDao: TodoDao
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachEventHandler()
        attachViewBinding()
    }

    private fun attachEventHandler() {
        binding.btnFeedMove.setOnClickListener {
            (requireActivity() as MainActivity).swipeFragment(
                0,
                true
            )
        }
    }

    private fun attachViewBinding() {

    }

}