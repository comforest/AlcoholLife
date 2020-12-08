package com.software.engineering.alcohollife.model.data

import com.google.gson.annotations.SerializedName

data class ResultContainer<T>(
    val result : List<T>
)