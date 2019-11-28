package guuilp.github.com.remote.di

import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.remote.character.CharacterRemoteImpl
import guuilp.github.com.remote.character.CharacterService
import guuilp.github.com.remote.character.mapper.CharacterEntityMapper
import guuilp.github.com.remote.common.EntityMapper
import guuilp.github.com.remote.character.model.CharacterResponse
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
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(get())
            .build()
    }

    single<CharacterService> {
        get<Retrofit>().create()
    }

    single<EntityMapper<CharacterResponse, CharacterEntity>> {
        CharacterEntityMapper()
    }

    single<CharacterRemote> {
        CharacterRemoteImpl(get(), get())
    }
}