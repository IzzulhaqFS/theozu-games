package com.izzulhaqfs.theozugames.core.data.source.local

import com.izzulhaqfs.theozugames.core.data.source.local.entity.GameEntity
import com.izzulhaqfs.theozugames.core.data.source.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gameDao: GameDao) {
    fun getAllGame(): Flow<List<GameEntity>> = gameDao.getAllGame()

    suspend fun insertGame(games: List<GameEntity>) = gameDao.insertGame(games)
}