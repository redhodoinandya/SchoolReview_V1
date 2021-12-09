package com.dicoding.schoolreview.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.schoolreview.R
import com.dicoding.schoolreview.data.SchoolEntity
import com.dicoding.schoolreview.databinding.ItemsSchooltangkotBinding
import com.dicoding.schoolreview.detail.DetailTangkotActivity
import java.util.*
import kotlin.collections.ArrayList

class searchAdapter : RecyclerView.Adapter<searchAdapter.SearchiewHolder>() {
    private var listSearchedSchool = ArrayList<SchoolEntity>()


    fun setSearchSchol(courses: List<SchoolEntity>?,string: String) {

        if (courses == null)  return

        this.listSearchedSchool.clear()

      courses.forEach {
          if (it.name.toLowerCase(Locale.getDefault()).contains(string)){
              this.listSearchedSchool.add(it)
          }
      }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchiewHolder {
        val itemsSchooltangkotBinding = ItemsSchooltangkotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchiewHolder(itemsSchooltangkotBinding)
    }

    override fun onBindViewHolder(holder: SearchiewHolder, position: Int) {
        val course = listSearchedSchool[position]
        holder.bind(course)


    }



    override fun getItemCount(): Int = listSearchedSchool.size

    class SearchiewHolder(private val binding: ItemsSchooltangkotBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(course: SchoolEntity) {
            with(binding) {
                tvItemTitle.text = course.name
                tvItemDate.text = course.number
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTangkotActivity::class.java)
                    intent.putExtra(DetailTangkotActivity.EXTRA_TANGKOT, course.name)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(course.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }
}