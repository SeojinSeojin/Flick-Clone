package org.sopt.flickclone.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.presentation.base.ViewBindingFragment
import org.sopt.flickclone.databinding.FragmentTodoHistoryBinding

@AndroidEntryPoint
class TodoHistoryFragment : ViewBindingFragment<FragmentTodoHistoryBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTodoHistoryBinding {
        return FragmentTodoHistoryBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachEventHandler()
    }

    private fun attachEventHandler() {
        binding.btnHistoryMove.setOnClickListener {
            (requireActivity() as MainActivity).swipeFragment(
                1,
                true
            )
        }
    }
}