package com.dicoding.schoolreview.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import com.dicoding.schoolreview.activity.SearchActivity

import com.dicoding.schoolreview.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {






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


        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(com.dicoding.schoolreview.R.id.btmsearch)?.actionView as  SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(com.dicoding.schoolreview.R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val searchLaunch = Intent(this@MainActivity, SearchActivity::class.java)
                searchLaunch.putExtra("qSearched",query)
                startActivity(searchLaunch)





                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })


        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}