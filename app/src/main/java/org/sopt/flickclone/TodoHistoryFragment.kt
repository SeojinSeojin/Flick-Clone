package org.sopt.flickclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.flickclone.base.ViewBindingFragment
import org.sopt.flickclone.databinding.FragmentTodoHistoryBinding

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