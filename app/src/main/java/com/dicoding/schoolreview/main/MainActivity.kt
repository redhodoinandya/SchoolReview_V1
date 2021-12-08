package com.dicoding.schoolreview.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater

import com.dicoding.schoolreview.databinding.ActivityMainBinding
import com.dicoding.schoolreview.fragment.SearchFragment




class MainActivity : AppCompatActivity() {

    private  val searchFragment =SearchFragment()


    lateinit var activityHomeBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        activityHomeBinding.viewPager.adapter = sectionsPagerAdapter
        activityHomeBinding.tabs.setupWithViewPager(activityHomeBinding.viewPager)
        supportActionBar?.elevation = 0f






    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       val inflater:MenuInflater =menuInflater
        inflater.inflate(com.dicoding.schoolreview.R.menu.menu,menu)


        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}