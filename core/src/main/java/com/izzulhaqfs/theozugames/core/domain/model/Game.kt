package com.izzulhaqfs.theozugames.core.domain.model

data class Game(
    val id: Int,
    val name: String,
    val released: String,
    val tba: Boolean,
    val backgroundImage: String,
    val rating: Double,
    val ratingsCount: Int,
    val playtime: Int,
    val esrbRating: String
)
