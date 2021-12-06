package com.dicoding.schoolreview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.schoolreview.R
import com.dicoding.schoolreview.databinding.FragmentTangkotBinding
import com.dicoding.schoolreview.utils.DataSchool

class TangkotFragment : Fragment() {
    private lateinit var fragmentTangkotBinding: FragmentTangkotBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentTangkotBinding = FragmentTangkotBinding.inflate(layoutInflater, container, false)
        return fragmentTangkotBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val courses = DataSchool.generateTangkotSchool()
            val academyAdapter = TangkotSchoolAdapter()
            academyAdapter.setTangkotSchol(courses)
            with(fragmentTangkotBinding.rvSchooltangkot) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}