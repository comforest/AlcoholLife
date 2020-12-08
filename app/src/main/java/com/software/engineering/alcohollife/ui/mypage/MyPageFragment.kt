package com.software.engineering.alcohollife.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.software.engineering.alcohollife.App
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.network.base.ApiStatus
import com.software.engineering.alcohollife.model.network.base.RestClient
import com.software.engineering.alcohollife.ui.base.BaseFragment
import com.software.engineering.alcohollife.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_mypage.*

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

        textview_mypage_signout.setOnClickListener {
            model.logout().observe(viewLifecycleOwner, Observer {
                when (it) {
                    is ApiStatus.Success -> {
                        App.prefs.userName = ""
                        App.prefs.idToken = ""
                        val intent = Intent(context, LoginActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
        notifyDataSetChange()
    }


    fun notifyDataSetChange() {
        model.getMyReviews().observe(viewLifecycleOwner, Observer {
            if (it is ApiStatus.Success) {
                val list = it.data.result
                textview_mypage_username.text = App.prefs.userName
                textview_mypage_review.text = list.size.toString()
                storyListFragment.setData(list)
            }
        })
    }

}