package com.example.ii3510_2425_smallproject_g1_toledanochloe

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3 // Number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> ProfileFragment()
            2 -> SettingsFragment()
            else -> HomeFragment()
        }
    }
}
