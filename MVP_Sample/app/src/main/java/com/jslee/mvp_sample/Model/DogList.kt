package com.jslee.mvp_sample.Model

object DogList {
    fun getDogList(): List<Dog> {
        return listOf(
            Dog("말티즈", "3"),
            Dog("시베리안 허스키", "4"),
            Dog("불독", "1")
        )
    }
}