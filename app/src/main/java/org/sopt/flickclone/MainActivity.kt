package org.sopt.flickclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.flickclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        attachViewpagerAdapter()
    }

    private fun attachViewpagerAdapter() {
        val viewpager = binding.viewpagerMain
        viewpager.adapter = MainFragmentStateAdapter(this)
        viewpager.setCurrentItem(1, false)
    }
}