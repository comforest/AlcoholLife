package com.software.engineering.alcohollife.model.data

data class CategoryData(
        val name: String,
        val type: String
){
    companion object {
        fun getSample() : CategoryData = CategoryData(
                "젝 허니",
                 "위스키"
        )

        fun getSampleList() : List<CategoryData> = listOf(
                getSample(),
                getSample(),
                getSample(),
                getSample()
        )
    }
}