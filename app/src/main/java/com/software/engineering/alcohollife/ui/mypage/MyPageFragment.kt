package com.software.engineering.alcohollife.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.software.engineering.alcohollife.App
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.AlcoholSimpleData
import com.software.engineering.alcohollife.model.network.base.ApiStatus
import com.software.engineering.alcohollife.model.network.base.RestClient
import com.software.engineering.alcohollife.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class MyPageFragment : BaseFragment() {
    private val model by lazy { RestClient.getDrinkService() }
    private val storyListFragment by lazy { StoryListFragment() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentManager?.let {
            it.beginTransaction()
            .add(R.id.fragment_mypage_review, storyListFragment)
            .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        notifyDataSetChange()
    }


    fun notifyDataSetChange() {
        model.getMyReviews().observe(viewLifecycleOwner, Observer {
            if (it is ApiStatus.Success){
                val list = it.data.result
                textview_mypage_username.text = App.prefs.userName
                textview_mypage_review.text = list.size.toString()
                storyListFragment.setData(list)
            }
        })
    }

}