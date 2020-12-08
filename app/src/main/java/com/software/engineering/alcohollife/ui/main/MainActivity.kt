package com.software.engineering.alcohollife.ui.main

import android.os.Bundle
import android.view.View
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.ui.base.BaseActivity
import com.software.engineering.alcohollife.ui.category.CategoryFragment
import com.software.engineering.alcohollife.ui.mypage.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_category -> {
                    goToCategory()
                }
                R.id.menu_main -> {
                    goToMain()
                }
                R.id.menu_mypage -> {
                    goToMyPage()
                }
                else ->
                    return@setOnNavigationItemSelectedListener false
            }

            return@setOnNavigationItemSelectedListener true
        }

        navigation_main.selectedItemId = R.id.menu_main
    }

    fun goToCategory() {
        fragment_main_category.view?.visibility = View.VISIBLE
        fragment_main_main.view?.visibility = View.GONE
        fragment_main_mypage.view?.visibility = View.GONE
    }

    fun goToCategory(category: String){
        navigation_main.selectedItemId = R.id.menu_category
        (fragment_main_category as CategoryFragment).setPage(category)
    }

    fun goToMain() {
        fragment_main_category.view?.visibility = View.GONE
        fragment_main_main.view?.visibility = View.VISIBLE
        fragment_main_mypage.view?.visibility = View.GONE
    }

    fun goToMyPage() {
        fragment_main_category.view?.visibility = View.GONE
        fragment_main_main.view?.visibility = View.GONE
        fragment_main_mypage.view?.visibility = View.VISIBLE
    }
}