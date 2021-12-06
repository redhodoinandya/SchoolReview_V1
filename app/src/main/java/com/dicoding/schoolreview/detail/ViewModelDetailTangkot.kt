package com.dicoding.schoolreview.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.utils.DataSchool

class ViewModelDetailTangkot: ViewModel() {
    private lateinit var title1: String

    fun setSelectTitle(title: String){
        this.title1 = title
    }

    fun getTangkot(): SchoolEntity{
        lateinit var movies: SchoolEntity

        val moviesEntities = DataSchool.generateTangkotSchool()
        for(movieentitt in moviesEntities){
            if (movieentitt.name == title1)
                movies = movieentitt
        }
        return movies
    }
}