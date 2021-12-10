package com.dicoding.schoolreview.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.schoolreview.R
import com.dicoding.schoolreview.databinding.FragmentTangkotBinding
import com.dicoding.schoolreview.databinding.FragmentTangselBinding
import com.dicoding.schoolreview.utils.DataSchool




class TangselFragment : Fragment() {
    private lateinit var fragmentTangselBinding: FragmentTangselBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTangselBinding = FragmentTangselBinding.inflate(layoutInflater, container, false)

        return fragmentTangselBinding.root



    }









    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val courses = DataSchool.generateTangselSchool()
            val academyAdapter = TangselSchoolAdapter()
            academyAdapter.setTangselSchool(courses)
            with(fragmentTangselBinding.rvSchooltangsel) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }

    }




}