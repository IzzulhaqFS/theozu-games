package com.izzulhaqfs.theozugames.core.utils

import com.izzulhaqfs.theozugames.core.data.source.local.entity.GameEntity
import com.izzulhaqfs.theozugames.core.data.source.remote.response.GameResponse
import com.izzulhaqfs.theozugames.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GameResponse>): List<GameEntity> {
        val games = ArrayList<GameEntity>()
        input.map {
            val game = GameEntity(
                id = it.id,
                name = it.name,
                released = it.released,
                tba = it.tba,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                playtime = it.playtime,
                esrbRating = it.esrbRating.name
            )
            games.add(game)
        }
        return games
    }

    fun mapEntitiesToDomain(input: List<GameEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                name = it.name,
                released = it.released,
                tba = it.tba,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                playtime = it.playtime,
                esrbRating = it.esrbRating
            )
        }

    fun mapDomainToEntity(input: Game) = GameEntity(
        id = input.id,
        name = input.name,
        released = input.released,
        tba = input.tba,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        playtime = input.playtime,
        esrbRating = input.esrbRating
    )
}