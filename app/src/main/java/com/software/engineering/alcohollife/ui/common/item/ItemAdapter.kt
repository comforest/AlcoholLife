package com.software.engineering.alcohollife.ui.common.item

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.CategoryData
import com.software.engineering.alcohollife.ui.common.BaseViewHolder
import kotlinx.android.synthetic.main.item_category.*

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.CategoryViewHolder>() {
    private var list: List<CategoryData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val data = list!![position]

        holder.textivew_category_name.text = data.name
        holder.textivew_category_type.text = data.type

        holder.textview_category_rating_score.text = data.rating.toString()
        holder.textview_category_rating_voter.text = "(${data.voter})"
    }

    fun setData(list: List<CategoryData>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(v: View) : BaseViewHolder(v)
}