package com.dicoding.schoolreview.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.utils.DataSchool

class ViewModelDetailTangsel: ViewModel() {
    private lateinit var title2: String

    fun setSelectTitle(title: String){
        this.title2 = title
    }

    fun getTangsel(): SchoolEntity{
        lateinit var movies: SchoolEntity

        val moviesEntities = DataSchool.generateTangselSchool()
        for(movieentitt in moviesEntities){
            if (movieentitt.name == title2)
                movies = movieentitt
        }
        return movies
    }
}