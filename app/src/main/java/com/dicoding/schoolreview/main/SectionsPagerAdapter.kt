package com.dicoding.schoolreview.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.schoolreview.R
import com.dicoding.schoolreview.fragment.TangkotFragment
import com.dicoding.schoolreview.fragment.TangselFragment

class SectionsPagerAdapter (private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tangkot, R.string.tangsel)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> TangkotFragment()
            1 -> TangselFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}