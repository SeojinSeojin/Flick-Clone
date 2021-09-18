package org.sopt.flickclone.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class MainFragmentStateAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val todoHistoryFragment: TodoHistoryFragment by lazy {
        TodoHistoryFragment()
    }
    private val todoFeedFragment: TodoFeedFragment by lazy {
        TodoFeedFragment()
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> todoHistoryFragment
            else -> todoFeedFragment
        }
    }

    override fun getItemCount(): Int = 2
}