package com.software.engineering.alcohollife.model.data

import com.google.gson.annotations.SerializedName

data class CategoryList (
    @SerializedName("result") val list:List<CategoryData>
)