package com.izzulhaqfs.theozugames.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "tba")
    val tba: Boolean,

    @ColumnInfo(name = "background_image")
    val backgroundImage: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "ratings_count")
    val ratingsCount: Int,

    @ColumnInfo(name = "playtime")
    val playtime: Int,

    @ColumnInfo(name = "esrb_rating")
    val esrbRating: String,
)
