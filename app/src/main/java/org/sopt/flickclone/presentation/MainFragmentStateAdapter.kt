package org.sopt.flickclone.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class MainFragmentStateAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf<Fragment>(TodoHistoryFragment(), TodoFeedFragment())

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int = fragments.size
}