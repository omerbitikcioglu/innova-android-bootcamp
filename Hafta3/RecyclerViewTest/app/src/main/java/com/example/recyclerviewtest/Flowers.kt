package com.example.recyclerviewtest

import java.io.Serializable

data class Flowers(
    var id: Int,
    var img: String,
    var title: String,
    var price: String,
    var rating: Float,
    var voteCount: Int,
    var instalment: String
) : Serializable
