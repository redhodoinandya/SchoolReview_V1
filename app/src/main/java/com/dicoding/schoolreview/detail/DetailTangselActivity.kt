package com.dicoding.schoolreview.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.databinding.ActivityDetailTangselBinding
import com.dicoding.schoolreview.databinding.ContentDetailTangselBinding

class DetailTangselActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TANGSEL = "extra_tangsel"
    }

    private lateinit var detailContentTangselBinnding: ContentDetailTangselBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTangselBinding = ActivityDetailTangselBinding.inflate(layoutInflater)
        detailContentTangselBinnding = activityDetailTangselBinding.detailContent2
        setContentView(activityDetailTangselBinding.root)

        val viewmodel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ViewModelDetailTangsel::class.java]

        val extras = intent.extras
        val faktor = extras?.getString(EXTRA_TANGSEL)
        if (extras != null) {
            if (faktor != null) {
                // println(viewModel)
                viewmodel.setSelectTitle(faktor)
                populatemovies(viewmodel.getTangsel())
            }
        }
    }

    private fun populatemovies(geCinema: SchoolEntity) {
        detailContentTangselBinnding.textName.text = geCinema.name
        detailContentTangselBinnding.textNomer.text = geCinema.number
        detailContentTangselBinnding.textJalan.text = geCinema.street
        Glide.with(this@DetailTangselActivity).load(geCinema.imagePath).into(detailContentTangselBinnding.imagePoster)

    }
}