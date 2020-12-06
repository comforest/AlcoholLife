package com.software.engineering.alcohollife.model.network

import retrofit2.http.GET
import retrofit2.http.Path

interface DrinkRetrofit {
    @GET("drink/{type}/{alcohol}/")
    fun getAlcohol(
        @Path("type") type: String,
        @Path("alcohol") alcohol: String
    )
}