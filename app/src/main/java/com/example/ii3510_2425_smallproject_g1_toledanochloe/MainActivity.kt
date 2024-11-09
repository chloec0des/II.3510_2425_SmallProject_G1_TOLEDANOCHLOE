package com.example.ii3510_2425_smallproject_g1_toledanochloe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Profile"
                2 -> "Settings"
                else -> "Tab ${position + 1}"
            }
        }.attach()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_settings -> {
                    replaceFragment(SettingsFragment())
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }
    }

    // Function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment) // content_frame is the container in activity_main.xml
            .commit()
    }
}
