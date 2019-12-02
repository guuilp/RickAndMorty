package guuilp.github.com.domain.di

import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import org.koin.dsl.module

val domainModule = module {
    single<UseCase<List<CharacterDomain>, Void?>> {
        GetAllCharactersUseCase(get())
    }
}