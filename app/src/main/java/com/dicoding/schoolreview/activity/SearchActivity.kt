package com.dicoding.schoolreview.activity

import android.app.SearchManager
import android.content.Context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.Menu
import android.view.MenuInflater

import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager

import com.dicoding.schoolreview.databinding.FragmentTangkotBinding

import com.dicoding.schoolreview.fragment.searchAdapter

import com.dicoding.schoolreview.utils.DataSchool
import java.util.*


class SearchActivity : AppCompatActivity() {







    private lateinit var searchBinding: FragmentTangkotBinding
    val academyAdapter = searchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        searchBinding = FragmentTangkotBinding.inflate(layoutInflater)
        setContentView(searchBinding.root)
        val qSearched=intent.getStringExtra("qSearched")
        searchnow(qSearched.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(com.dicoding.schoolreview.R.menu.menu_search,menu)


        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(com.dicoding.schoolreview.R.id.btmsearch)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(com.dicoding.schoolreview.R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {





                return true
            }
            override fun onQueryTextChange(newText: String): Boolean {

                val searchText =newText.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    searchnow(newText)




                }
                return false
            }
        })


        return true
    }

    fun searchnow(newText : String){
        val courses = DataSchool.generateTangkotSchool() + DataSchool.generateTangselSchool()
        academyAdapter.setSearchSchol(courses,newText)
        with(searchBinding.rvSchooltangkot) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = academyAdapter


        }
    }



}