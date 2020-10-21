package com.software.engineering.alcohollife.ui.category

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
import com.software.engineering.alcohollife.ui.common.item.ItemListFragment
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewpager_category.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager_category.adapter = ViewPagerAdapter()

        TabLayoutMediator(tablayout_category, viewpager_category) { tab, position ->
            tab.text = when (position) {
                0 -> "0"
                1 -> "1"
                else -> "???"
            }
        }.attach()

    }

    inner class ViewPagerAdapter : FragmentStateAdapter(this) {
        private val fragmentList = listOf(
                ItemListFragment(),
                ItemListFragment(),
                ItemListFragment(),
                ItemListFragment(),
                ItemListFragment(),
                ItemListFragment()
        )

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }
}