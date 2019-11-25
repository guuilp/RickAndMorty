package guuilp.github.com.data.di

import guuilp.github.com.data.CharacterDataRepository
import guuilp.github.com.data.mapper.CharacterModelMapper
import guuilp.github.com.data.mapper.Mapper
import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.domain.model.CharacterModel
import guuilp.github.com.domain.repository.CharacterRepository
import org.koin.dsl.module

val dataModule = module {
    single<Mapper<CharacterEntity, CharacterModel>> {
        CharacterModelMapper()
    }

    single<CharacterRepository> {
        CharacterDataRepository(get(), get())
    }
}