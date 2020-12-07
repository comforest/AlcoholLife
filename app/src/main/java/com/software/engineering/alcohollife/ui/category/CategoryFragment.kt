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

    private val categoryList = listOf(
        "소주",
        "맥주",
        "양주"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewpager_category.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager_category.adapter = ViewPagerAdapter()
        viewpager_category.isSaveEnabled = false

        TabLayoutMediator(tablayout_category, viewpager_category) { tab, position ->
            tab.text = categoryList[position]
        }.attach()

    }

    inner class ViewPagerAdapter : FragmentStateAdapter(this) {
        override fun getItemCount(): Int {
            return categoryList.size
        }

        override fun createFragment(position: Int): Fragment {
            return ItemListFragment()
        }
    }

    fun setPage(page: Int) {
        viewpager_category.setCurrentItem(page, false)
    }

    fun setPage(category: String) {
        val index = categoryList.indexOf(category)
        if(index != -1) setPage(index)
    }
}