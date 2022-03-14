package com.example.exampleretrofit

import com.google.gson.annotations.SerializedName

data class Results(
    var id:Int,
    var title: String,
    @SerializedName("poster_path")
    val posterPath: Int
)