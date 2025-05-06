package com.whoisridze.lab4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.mainViewPager)
        val adapter = MainPagerAdapter(this)
        viewPager.adapter = adapter

        val tabLayout = findViewById<TabLayout>(R.id.mainTabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Static Fragments"
                1 -> tab.text = "ViewPager Navigation"
            }
        }.attach()
    }
}