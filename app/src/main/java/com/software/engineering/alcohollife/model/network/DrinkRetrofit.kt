package com.software.engineering.alcohollife.model.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkRetrofit {
    @GET("drink/{alcohol}/")
    fun getAlcohol(
        @Path("alcohol") alcohol: String
    ): Call<JsonObject>
}