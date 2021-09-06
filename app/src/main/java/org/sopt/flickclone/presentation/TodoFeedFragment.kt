package org.sopt.flickclone.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.presentation.base.ViewBindingFragment
import org.sopt.flickclone.databinding.FragmentTodoFeedBinding
import org.sopt.flickclone.model.TodoData
import org.sopt.flickclone.persistance.TodoDao
import java.sql.Date
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

@AndroidEntryPoint
class TodoFeedFragment : ViewBindingFragment<FragmentTodoFeedBinding>() {

    @Inject
    lateinit var todoDao: TodoDao

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTodoFeedBinding {
        return FragmentTodoFeedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachEventHandler()
    }

    private fun attachEventHandler() {
        binding.btnFeedMove.setOnClickListener {
            (requireActivity() as MainActivity).swipeFragment(
                0,
                true
            )
        }
    }

}