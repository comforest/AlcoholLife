package com.software.engineering.alcohollife.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.AlcoholSimpleData
import com.software.engineering.alcohollife.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_alcohol_grid_card.*

class AlcoholGridAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private var list: List<AlcoholSimpleData>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alcohol_grid_card, parent, false)

        return GridViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is GridViewHolder ->{
                holder.imageview_alcohol.setImageResource(R.drawable.img_jack_honey)
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

    class GridViewHolder(v: View) : BaseViewHolder(v)
}