package com.software.engineering.alcohollife.model.data

data class CategoryData(
    val name: String,
    val type: String,
    val rating: Double,
    val voter: Int
) {
    companion object {
        fun getSample(): CategoryData = CategoryData(
            "잭 허니",
            "위스키",
            4.77,
            5324
        )

        fun getSampleList(): List<CategoryData> = listOf(
            getSample(),
            getSample(),
            getSample(),
            getSample()
        )
    }
}