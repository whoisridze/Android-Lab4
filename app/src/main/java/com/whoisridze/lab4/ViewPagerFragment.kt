package com.whoisridze.lab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener { item ->
            val position = when(item.itemId) {
                R.id.page1 -> 0
                R.id.page2 -> 1
                R.id.page3 -> 2
                R.id.page4 -> 3
                else -> 0
            }
            viewPager.currentItem = position
            true
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val menuItem = bottomNav.menu.getItem(position)
                bottomNav.selectedItemId = menuItem.itemId
            }
        })
    }
}