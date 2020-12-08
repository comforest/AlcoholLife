package com.software.engineering.alcohollife.model.network

import com.google.gson.JsonObject
import com.software.engineering.alcohollife.model.data.AuthData
import com.software.engineering.alcohollife.model.data.CategoryList
import com.software.engineering.alcohollife.model.data.ResultContainer
import com.software.engineering.alcohollife.model.data.ReviewData
import com.software.engineering.alcohollife.model.network.base.ApiLiveData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkRetrofit {
    @GET("/drink/{alcohol}/")
    fun getAlcohol(
        @Path("alcohol") alcohol: String
    ): Call<JsonObject>

    @GET("/drink/items/{category}")
    fun getCategory(
        @Path("category") category: String
    ): ApiLiveData<CategoryList>


//    @POST("")
//    fun registerUser(
//        @Body data: AuthData
//    ): ApiLiveData<Any>

    @GET("/manageuser/reviews/")
    fun getMyReviews(): ApiLiveData<CategoryList>

    @GET("/drink/{alcohol}/reviews")
    fun getAlcoholReviews(
        @Path("alcohol") alcohol: String
    ): ApiLiveData<ResultContainer<ReviewData>>

}