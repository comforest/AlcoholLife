package com.software.engineering.alcohollife.ui.common.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.network.base.ApiStatus
import com.software.engineering.alcohollife.model.network.base.RestClient
import com.software.engineering.alcohollife.ui.base.BaseFragment
import com.software.engineering.alcohollife.ui.review.ItemPage
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*

class ItemListFragment private constructor(): BaseFragment() {
    private val model = RestClient.getDrinkService()
    private val adapter by lazy { ItemAdapter() }
    private val category by lazy { arguments!!.getString(ARGUMENTS_CATEGORY)!! }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerview.layoutManager = LinearLayoutManager(context)
        view.recyclerview.adapter = adapter

        adapter.setOnItemClickListener {
            val intent = ItemPage.getStartIntent(context, it.name)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        model.getCategory(category).observe(viewLifecycleOwner, Observer {
            when(it){
                is ApiStatus.Success-> {
                    adapter.setData(it.data.list)
                }
            }
        })
    }

    companion object {
        private const val ARGUMENTS_CATEGORY = "ARGUMENTS_CATEGORY"
        fun getInstance(category: String) = ItemListFragment().apply {
            arguments = Bundle().apply {
                putString(ARGUMENTS_CATEGORY, category)
            }
        }
    }
}