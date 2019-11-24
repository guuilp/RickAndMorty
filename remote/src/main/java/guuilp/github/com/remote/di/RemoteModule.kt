package guuilp.github.com.remote.di

import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.remote.CharacterService
import guuilp.github.com.remote.mapper.CharacterEntityMapper
import guuilp.github.com.remote.mapper.EntityMapper
import guuilp.github.com.remote.model.character.CharacterResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

val remoteModule = module {
    val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api")
            .client(get<OkHttpClient>())
            .build()
    }

    single<CharacterService> {
        get<Retrofit>().create()
    }

    single<EntityMapper<CharacterResponse, CharacterEntity>> {
        CharacterEntityMapper()
    }
}