package com.software.engineering.alcohollife.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.AlcoholSimpleData
import com.software.engineering.alcohollife.model.data.CategoryData
import com.software.engineering.alcohollife.ui.base.BaseFragment
import com.software.engineering.alcohollife.ui.common.AlcoholGridAdapter
import com.software.engineering.alcohollife.ui.common.item.ItemAdapter
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*

class StoryListFragment : BaseFragment() {
      private val adapter by lazy { AlcoholGridAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.layoutManager = GridLayoutManager(context, 2)
//        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        adapter.setData(AlcoholSimpleData.getSampleList())
    }

}