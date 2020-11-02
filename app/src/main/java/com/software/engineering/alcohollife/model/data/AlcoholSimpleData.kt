package com.software.engineering.alcohollife.model.data

data class AlcoholSimpleData(
    val id: Int
) {
    companion object {
        fun getSample() = AlcoholSimpleData(
            0
        )

        fun getSampleList() : List<AlcoholSimpleData> = listOf(
            getSample(),
            getSample(),
            getSample(),
            getSample()
        )
    }
}