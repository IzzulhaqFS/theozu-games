package com.izzulhaqfs.theozugames.core.di

import androidx.room.Room
import com.izzulhaqfs.theozugames.core.data.GameRepository
import com.izzulhaqfs.theozugames.core.data.source.local.LocalDataSource
import com.izzulhaqfs.theozugames.core.data.source.local.room.GameDatabase
import com.izzulhaqfs.theozugames.core.data.source.remote.RemoteDataSource
import com.izzulhaqfs.theozugames.core.data.source.remote.network.ApiService
import com.izzulhaqfs.theozugames.core.domain.repository.IGameRepository
import com.izzulhaqfs.theozugames.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java,
            "Game.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IGameRepository> {
        GameRepository(
            get(),
            get(),
            get()
        )
    }
}