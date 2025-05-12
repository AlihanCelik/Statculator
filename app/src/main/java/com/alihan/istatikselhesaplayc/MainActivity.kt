package com.alihan.istatikselhesaplayc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.alihan.istatikselhesaplayc.Hesaplayici.HesaplayiciFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var viewPagerAdapter: VpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewpager)
        bottomNavigation = findViewById(R.id.bottomNav)

        viewPagerAdapter = VpAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter

        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            val index = when (menuItem.itemId) {
                R.id.home -> 0
                R.id.trans -> 1
                else -> 0
            }
            viewPager.currentItem = index
            true
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigation.menu.getItem(position).isChecked = true
            }
        })

        viewPagerAdapter.addFragment(HesaplayiciFragment(), "Home")
        viewPagerAdapter.addFragment(KategoriFragment(), "Category")

        viewPager.currentItem = 0


    }



}