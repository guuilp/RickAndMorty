package guuilp.github.com.data.di

import guuilp.github.com.data.character.CharacterDataRepository
import guuilp.github.com.data.character.mapper.CharacterDomainMapper
import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.domain_model.character.CharacterDomain
import org.koin.dsl.module

val dataModule = module {
    single<Mapper<CharacterEntity, CharacterDomain>> {
        CharacterDomainMapper()
    }

    single<CharacterRepository> {
        CharacterDataRepository(get(), get())
    }
}