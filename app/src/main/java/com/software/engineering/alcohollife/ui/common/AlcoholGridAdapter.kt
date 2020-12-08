package com.software.engineering.alcohollife.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.AlcoholSimpleData
import com.software.engineering.alcohollife.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_alcohol_grid_card.*

class AlcoholGridAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var list: List<AlcoholSimpleData>? = null
    private var onItemClickListener: ((AlcoholSimpleData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alcohol_grid_card, parent, false)

        return GridViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val data = list!![position]
        when (holder) {
            is GridViewHolder -> {
                Glide.with(holder.containerView)
                    .load(data.image)
                    .into(holder.imageview_alcohol)
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    fun setData(data: List<AlcoholSimpleData>) {
        this.list = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: ((AlcoholSimpleData) -> Unit)?) {
        onItemClickListener = listener
    }

    inner class GridViewHolder(v: View) : BaseViewHolder(v) {
        init {
            v.setOnClickListener {
                onItemClickListener?.invoke(list!![adapterPosition])
            }
        }
    }
}