package com.izzulhaqfs.theozugames.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GameResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("released")
    val released: String,

    @field:SerializedName("tba")
    val tba: Boolean,

    @field:SerializedName("background_image")
    val backgroundImage: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("ratings_count")
    val ratingsCount: Int,

    @field:SerializedName("playtime")
    val playtime: Int,

    @field:SerializedName("esrb_rating")
    val esrbRating: EsrbRating,
)

data class EsrbRating(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("slug")
    val slug: String
)