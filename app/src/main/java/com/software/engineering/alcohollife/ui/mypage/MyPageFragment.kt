package com.software.engineering.alcohollife.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mypage.*

class MyPageFragment : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mypage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notifyDataSetChange()
        viewpager_mypage.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager_mypage.adapter = ViewPagerAdapter()

        TabLayoutMediator(tablayout_mypage, viewpager_mypage) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.all_story)
                1 -> getString(R.string.all_review)
                else -> ""
            }
        }.attach()
    }

    fun notifyDataSetChange() {
        textview_mypage_review.text = "!23"
        textview_mypage_story.text = "!23"
        textview_mypage_favorite.text = "!23"
    }

    inner class ViewPagerAdapter : FragmentStateAdapter(this) {
        private val fragmentList = listOf(
//            ItemListFragment(),
//            ItemListFragment()
            StoryListFragment(),
            StoryListFragment()
        )

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }
}