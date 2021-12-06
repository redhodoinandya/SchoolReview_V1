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

class TangkotSchoolAdapter: RecyclerView.Adapter<TangkotSchoolAdapter.TangkotViewHolder>() {
    private var listTangkotSchool = ArrayList<SchoolEntity>()

    fun setTangkotSchol(courses: List<SchoolEntity>?) {
        if (courses == null) return
        this.listTangkotSchool.clear()
        this.listTangkotSchool.addAll(courses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TangkotViewHolder {
        val itemsSchooltangkotBinding = ItemsSchooltangkotBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TangkotViewHolder(itemsSchooltangkotBinding)
    }

    override fun onBindViewHolder(holder: TangkotViewHolder, position: Int) {
        val course = listTangkotSchool[position]
        holder.bind(course)


    }

    override fun getItemCount(): Int = listTangkotSchool.size

    class TangkotViewHolder(private val binding: ItemsSchooltangkotBinding): RecyclerView.ViewHolder(binding.root) {
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