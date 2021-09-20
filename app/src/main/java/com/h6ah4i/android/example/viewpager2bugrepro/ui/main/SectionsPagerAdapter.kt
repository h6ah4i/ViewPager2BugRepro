package com.h6ah4i.android.example.viewpager2bugrepro.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return 6
    }
}