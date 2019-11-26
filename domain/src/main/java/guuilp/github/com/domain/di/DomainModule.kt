package guuilp.github.com.domain.di

import guuilp.github.com.domain.common.BaseUseCase
import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCase
import guuilp.github.com.domain_model.character.CharacterModel
import org.koin.dsl.module

val domainModule = module {
    single<BaseUseCase<List<CharacterModel>, Void?>> {
        GetAllCharactersUseCase(get())
    }
}