package com.dicoding.schoolreview.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.databinding.ActivityDetailTangkotBinding
import com.dicoding.schoolreview.databinding.ContentDetailTangkotBinding

class DetailTangkotActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TANGKOT = "extra_tangkot"
    }

    private lateinit var detailContentTangkotBinnding: ContentDetailTangkotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTangkotBinding = ActivityDetailTangkotBinding.inflate(layoutInflater)
        detailContentTangkotBinnding = activityDetailTangkotBinding.detailContent1
        setContentView(activityDetailTangkotBinding.root)

        val viewmodel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ViewModelDetailTangkot::class.java]

        val extras = intent.extras
        val faktor = extras?.getString(EXTRA_TANGKOT)
        if (extras != null) {
            if (faktor != null) {
                // println(viewModel)
                viewmodel.setSelectTitle(faktor)
                populatemovies(viewmodel.getTangkot())
            }
        }
    }

    private fun populatemovies(geCinema: SchoolEntity) {
        detailContentTangkotBinnding.textName.text = geCinema.name
        detailContentTangkotBinnding.textJalan.text = geCinema.street
        detailContentTangkotBinnding.textNomer.text = geCinema.number
        Glide.with(this@DetailTangkotActivity).load(geCinema.imagePath).into(detailContentTangkotBinnding.imagePoster)

    }
}