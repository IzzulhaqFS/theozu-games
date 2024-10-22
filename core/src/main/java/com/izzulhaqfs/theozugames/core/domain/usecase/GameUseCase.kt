package com.izzulhaqfs.theozugames.core.domain.usecase

import com.izzulhaqfs.theozugames.core.data.Resource
import com.izzulhaqfs.theozugames.core.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getAllGame(): Flow<Resource<List<Game>>>
}