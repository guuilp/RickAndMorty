package guuilp.github.com.character.di

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.mapper.CharacterViewMapper
import guuilp.github.com.character.model.CharacterView
import guuilp.github.com.character.presentation.CharacterListViewModel
import guuilp.github.com.domain_model.character.CharacterModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    single<Mapper<CharacterModel, CharacterView>> {
        CharacterViewMapper()
    }

    viewModel { CharacterListViewModel(get(), get()) }
}
