package com.software.engineering.alcohollife.model.network

import com.google.gson.JsonObject
import com.software.engineering.alcohollife.model.data.CategoryList
import com.software.engineering.alcohollife.model.data.SignUpData
import com.software.engineering.alcohollife.model.network.base.ApiLiveData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DrinkRetrofit {
    @GET("drink/{alcohol}/")
    fun getAlcohol(
        @Path("alcohol") alcohol: String
    ): Call<JsonObject>

    @GET("drink/items/{category}")
    fun getCategory(
        @Path("category") category: String
    ): ApiLiveData<CategoryList>

    @POST("manageuser/user/")
    fun signUp(
            @Body data: SignUpData
    ): ApiLiveData<Any>

}