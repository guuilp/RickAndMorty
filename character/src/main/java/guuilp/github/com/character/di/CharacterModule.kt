package guuilp.github.com.character.di

import guuilp.github.com.character.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    viewModel { CharacterViewModel(get()) }
}