package com.software.engineering.alcohollife.model.network

import com.google.gson.JsonObject
import com.software.engineering.alcohollife.model.data.*
import com.software.engineering.alcohollife.model.network.base.ApiLiveData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
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

    @POST("manageuser/user/")
    fun signUp(
        @Body data: SignUpData
    ): ApiLiveData<Any?>

    @POST("manageuser/login/")
    fun login(
        @Body loginData: LoginData
    ): ApiLiveData<TokenData>

    @POST("manageuser/review/")
    fun reviewPost(
        @Body reviewPostData: ReviewPostData
    ): ApiLiveData<Any>

}