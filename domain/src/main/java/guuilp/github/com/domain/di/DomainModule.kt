package guuilp.github.com.domain.di

import guuilp.github.com.domain.BaseUseCase
import guuilp.github.com.domain.interactor.character.GetAllCharactersUseCase
import guuilp.github.com.domain.model.CharacterModel
import org.koin.dsl.module

val domainModule = module {
    single<BaseUseCase<List<CharacterModel>, Void?>> {
        GetAllCharactersUseCase(get())
    }
}