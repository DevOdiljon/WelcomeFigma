package com.example.welcomefigma

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var btn_enter: Button
    private lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    fun initViews() {
        viewPager = findViewById(R.id.view_pager)
        btn_enter = findViewById(R.id.btn_enter)
        btn_login = findViewById(R.id.btn_login)

        viewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager())

        viewPagerAdapter.add(FirstFragment())
        viewPagerAdapter.add(SecondFragment())
        viewPagerAdapter.add(ThridFragment())
        viewPagerAdapter.add(FourthFragment())

        viewPager.adapter = viewPagerAdapter
        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

       var btn_enter = findViewById<Button>(R.id.btn_enter)
        btn_enter.setOnClickListener(View.OnClickListener {
            viewPager.currentItem = 4
        })

        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                if (position != 3){
                    btn_login.visibility = GONE
                    btn_login_2.visibility = VISIBLE
                } else {
                    btn_login.visibility = VISIBLE
                    btn_login_2.visibility = GONE
                }
            }
        })
    }
}