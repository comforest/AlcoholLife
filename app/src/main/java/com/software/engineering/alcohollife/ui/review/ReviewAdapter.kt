package com.software.engineering.alcohollife.ui.review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.ReviewData
import com.software.engineering.alcohollife.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_review.*

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    private var list: List<ReviewData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ReviewViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ReviewAdapter.ReviewViewHolder, position: Int) {
        val data = list!![position]
        holder.textview_review_username.text = data.userName
        holder.textview_review_content.text = data.content
        holder.textview_review_rating.text = data.rating.toString()
    }

    fun setData(list: List<ReviewData>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ReviewViewHolder(v: View) : BaseViewHolder(v)
}