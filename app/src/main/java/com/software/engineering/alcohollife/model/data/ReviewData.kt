package com.software.engineering.alcohollife.model.data

import com.google.gson.annotations.SerializedName

data class ReviewData(
    @SerializedName("username") val userName: String,
    val rating: Float,
    val content: String,
    @SerializedName("comment_count") val commentCount: Int
)