package com.izzulhaqfs.theozugames.core.domain.repository

import com.izzulhaqfs.theozugames.core.data.Resource
import com.izzulhaqfs.theozugames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface IGameRepository {
    fun getAllGame(): Flow<Resource<List<Game>>>
}