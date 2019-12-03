package guuilp.github.com.domain.di

import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCase
import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCaseImpl
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetAllCharactersUseCase> {
        GetAllCharactersUseCaseImpl(get())
    }

    single<GetSingleCharacterUseCase> {
        GetSingleCharacterUseCaseImpl(get())
    }
}
