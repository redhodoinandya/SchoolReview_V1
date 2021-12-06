package com.dicoding.schoolreview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.schoolreview.R
import com.dicoding.schoolreview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}