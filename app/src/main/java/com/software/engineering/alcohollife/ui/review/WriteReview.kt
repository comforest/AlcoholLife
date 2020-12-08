package com.software.engineering.alcohollife.ui.review

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.ReviewData
import com.software.engineering.alcohollife.model.data.ReviewPostData
import com.software.engineering.alcohollife.model.network.base.ApiStatus
import com.software.engineering.alcohollife.model.network.base.RestClient
import kotlinx.android.synthetic.main.activity_item_page.*
import kotlinx.android.synthetic.main.activity_write_review.*

class WriteReview : AppCompatActivity() {
    private val model = RestClient.getDrinkService()

    private val alcoholName by lazy { intent!!.getStringExtra(EXTRA_ALCOHOL_NAME)!! }
    private val imgUrl by lazy { intent!!.getStringExtra(EXTRA_IMG_URL)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_review)

        val toolbar = findViewById<View>(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)

        textView.text = alcoholName

        Glide.with(this)
            .load(imgUrl)
            .into(imageView)



        button2.setOnClickListener {
            review_submit(ratingBar.rating, alcoholName, editText.text.toString())
        }
    }

    fun review_submit(rating:Float, name:String, review_text:String) {
        model.reviewPost(ReviewPostData(rating, name, review_text)).observe(this, Observer {
            when (it) {
                is ApiStatus.Success -> {
                    Toast.makeText(applicationContext, "리뷰등록이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val EXTRA_ALCOHOL_NAME = "EXTRA_ALCOHOL_NAME"
        private const val EXTRA_IMG_URL = "EXTRA_IMG_URL"
        fun getStartIntent(context: Context?, alcohol: String, img: String): Intent {
            return Intent(context, WriteReview::class.java).apply {
                putExtra(EXTRA_ALCOHOL_NAME, alcohol)
                putExtra(EXTRA_IMG_URL, img)
            }

        }
    }
}