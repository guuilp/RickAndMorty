package guuilp.github.com.character.di

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.mapper.CharacterListItemViewMapper
import guuilp.github.com.character.model.CharacterListItemView
import guuilp.github.com.character.presentation.CharacterListViewModel
import guuilp.github.com.domain_model.character.CharacterDomain
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    single<Mapper<CharacterDomain, CharacterListItemView>> {
        CharacterListItemViewMapper()
    }

    viewModel { CharacterListViewModel(get(), get()) }
}
