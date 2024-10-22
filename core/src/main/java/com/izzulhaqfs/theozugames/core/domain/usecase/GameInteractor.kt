package com.izzulhaqfs.theozugames.core.domain.usecase

import com.izzulhaqfs.theozugames.core.data.Resource
import com.izzulhaqfs.theozugames.core.domain.model.Game
import com.izzulhaqfs.theozugames.core.domain.repository.IGameRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val gameRepository: IGameRepository): GameUseCase {
    override fun getAllGame(): Flow<Resource<List<Game>>> {
        return gameRepository.getAllGame()
    }
}