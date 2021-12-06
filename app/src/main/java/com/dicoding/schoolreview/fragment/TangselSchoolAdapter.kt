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
import com.dicoding.schoolreview.databinding.ItemsSchooltangselBinding
import com.dicoding.schoolreview.detail.DetailTangkotActivity
import com.dicoding.schoolreview.detail.DetailTangselActivity

class TangselSchoolAdapter: RecyclerView.Adapter<TangselSchoolAdapter.TangselViewHolder>() {
    private var listTangselSchool = ArrayList<SchoolEntity>()

    fun setTangselSchool(courses: List<SchoolEntity>?) {
        if (courses == null) return
        this.listTangselSchool.clear()
        this.listTangselSchool.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TangselViewHolder {
        val itemsSchooltangselBinding = ItemsSchooltangselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TangselViewHolder(itemsSchooltangselBinding)
    }

    override fun onBindViewHolder(holder: TangselViewHolder, position: Int) {
        val course = listTangselSchool[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listTangselSchool.size

    class TangselViewHolder(private val binding: ItemsSchooltangselBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(course: SchoolEntity) {
            with(binding) {
                tvItemTitle.text = course.name
                tvItemDate.text = course.number
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTangselActivity::class.java)
                    intent.putExtra(DetailTangselActivity.EXTRA_TANGSEL, course.name)
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