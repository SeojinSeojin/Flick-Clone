package org.sopt.flickclone.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.flickclone.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachViewpagerAdapter()
    }

    private fun attachViewpagerAdapter() {
        binding.viewpagerMain.adapter = MainFragmentStateAdapter(this)
        binding.viewpagerMain.setCurrentItem(1, false)
    }

    fun swipeFragment(index: Int, isSmooth: Boolean) {
        binding.viewpagerMain.setCurrentItem(index, isSmooth)
    }
}