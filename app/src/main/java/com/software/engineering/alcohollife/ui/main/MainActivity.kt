package com.software.engineering.alcohollife.ui.main

import android.os.Bundle
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.ui.base.BaseActivity
import com.software.engineering.alcohollife.ui.category.CategoryFragment
import com.software.engineering.alcohollife.ui.mypage.MyPageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val categoryFragment by lazy { CategoryFragment() }
    private val mainFragment by lazy { MainFragment() }
    private val myPageFragment by lazy { MyPageFragment() }

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
    }

    fun goToCategory() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main, categoryFragment)
                .commit()
    }

    fun goToMain() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_main, mainFragment)
                .commit()
    }

    fun goToMyPage() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main, myPageFragment)
            .commit()
    }
}