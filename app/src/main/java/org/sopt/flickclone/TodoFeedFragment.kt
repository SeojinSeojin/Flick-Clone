package org.sopt.flickclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.flickclone.base.ViewBindingFragment
import org.sopt.flickclone.databinding.FragmentTodoFeedBinding

class TodoFeedFragment : ViewBindingFragment<FragmentTodoFeedBinding>() {
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