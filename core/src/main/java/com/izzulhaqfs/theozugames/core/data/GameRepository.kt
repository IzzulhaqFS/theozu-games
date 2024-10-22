package com.izzulhaqfs.theozugames.core.data

import com.izzulhaqfs.theozugames.core.data.source.local.LocalDataSource
import com.izzulhaqfs.theozugames.core.data.source.remote.RemoteDataSource
import com.izzulhaqfs.theozugames.core.data.source.remote.network.ApiResponse
import com.izzulhaqfs.theozugames.core.data.source.remote.response.GameResponse
import com.izzulhaqfs.theozugames.core.domain.model.Game
import com.izzulhaqfs.theozugames.core.domain.repository.IGameRepository
import com.izzulhaqfs.theozugames.core.utils.AppExecutors
import com.izzulhaqfs.theozugames.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutor: AppExecutors
) : IGameRepository {
    override fun getAllGame(): Flow<Resource<List<Game>>> {
        return object : NetworkBoundResource<List<Game>, List<GameResponse>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getAllGame().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GameResponse>>> {
                return remoteDataSource.getAllGame()
            }

            override suspend fun saveCallResult(data: List<GameResponse>) {
                val games = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGame(games)
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()
        }.asFlow()
    }
}