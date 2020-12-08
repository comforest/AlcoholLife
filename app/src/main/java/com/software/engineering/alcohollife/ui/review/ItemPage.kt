package com.software.engineering.alcohollife.ui.review

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.ItemData
import com.software.engineering.alcohollife.model.network.base.ApiStatus
import com.software.engineering.alcohollife.model.network.base.RestClient
import kotlinx.android.synthetic.main.activity_item_page.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemPage : AppCompatActivity() {
    private val model = RestClient.getDrinkService()
    private val name by lazy { intent.getStringExtra(EXTRA_NAME) ?: "" }
    private val reviewAdapter by lazy { ReviewAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_page)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(false)
        ab.setDisplayHomeAsUpEnabled(true)


        recyclerview_itempage_reviews.layoutManager = LinearLayoutManager(this)
        recyclerview_itempage_reviews.adapter = reviewAdapter

    }

    override fun onStart() {
        super.onStart()

        val call = model.getAlcohol(name)
        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {}

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                CoroutineScope(Dispatchers.Main).launch {
                    val code = response.code()
                    if (response.isSuccessful) {
                        val json = response.body()
                        val gson = Gson()
                        val data =
                            gson.fromJson<ItemData>(json!!.get("result"), ItemData::class.java)
                        setData(data)
                        return@launch
                    }
                    // TODO: Error 처리
                }

            }
        })

        model.getAlcoholReviews(name).observe(this, Observer {
            when (it) {
                is ApiStatus.Success -> {
                    val list = it.data.result
                    reviewAdapter.setData(list)

                    textview_itempage_nonreview.visibility =
                        if (list.isEmpty()) View.VISIBLE else View.GONE
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setData(data: ItemData) {
        Glide.with(this)
            .load(data.image)
            .into(imageView2)

        floatingActionButton2.setOnClickListener {
            val intent = WriteReview.getStartIntent(this, name, data.image)
            startActivity(intent)
        }
        textView5.text = data.rating.toString()
        toolbar_title.text = data.name
        item_name2.text = data.name
    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        fun getStartIntent(context: Context?, alcohol: String): Intent {
            return Intent(context, ItemPage::class.java).apply {
                putExtra(EXTRA_NAME, alcohol)
            }
        }
    }
}