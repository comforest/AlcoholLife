package com.software.engineering.alcohollife.ui.review

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.software.engineering.alcohollife.R
import com.software.engineering.alcohollife.model.data.ItemData
import com.software.engineering.alcohollife.model.network.base.RestClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemPage : AppCompatActivity() {
    private val model = RestClient.getDrinkService()
    private val name by lazy { intent.getStringExtra(EXTRA_NAME) ?: "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_page)

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
    }

    fun setData(data : ItemData){

    }

    companion object {
        private const val EXTRA_NAME = "EXTRA_NAME"
        fun getStartIntent(context: Context, alcohol: String): Intent {
            return Intent(context, this::class.java).apply {
                putExtra(EXTRA_NAME, alcohol)
            }

        }
    }
}