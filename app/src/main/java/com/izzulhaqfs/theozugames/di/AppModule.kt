package com.izzulhaqfs.theozugames.di

import com.izzulhaqfs.theozugames.core.domain.usecase.GameInteractor
import com.izzulhaqfs.theozugames.core.domain.usecase.GameUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
}