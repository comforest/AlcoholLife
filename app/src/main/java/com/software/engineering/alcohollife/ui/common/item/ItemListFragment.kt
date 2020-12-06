package com.software.engineering.alcohollife.ui.common.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.CategoryData
import com.software.engineering.alcohollife.ui.base.BaseFragment
import com.software.engineering.alcohollife.ui.common.item.ItemAdapter
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*

class ItemListFragment : BaseFragment() {
    private val adapter by lazy { ItemAdapter() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerview.layoutManager = LinearLayoutManager(context)
        view.recyclerview.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.setData(CategoryData.getSampleList())
    }
}