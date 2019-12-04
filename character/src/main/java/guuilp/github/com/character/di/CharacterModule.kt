package guuilp.github.com.character.di

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.mapper.CharacterDetailViewMapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.character.detail.presentation.CharacterDetailViewModel
import guuilp.github.com.character.list.mapper.CharacterListItemViewMapper
import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.character.list.presentation.CharacterListViewModel
import guuilp.github.com.domain_model.character.CharacterDomain
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val loadFeature by lazy { loadKoinModules(characterModule) }
internal fun injectFeature() = loadFeature

private const val CHARACTER_LIST_VIEW_MAPPER = "CHARACTER_LIST_VIEW_MAPPER"
private const val CHARACTER_DETAIL_VIEW_MAPPER = "CHARACTER_DETAIL_VIEW_MAPPER"

val characterModule = module {
    single(named(CHARACTER_LIST_VIEW_MAPPER)) {
        CharacterListItemViewMapper() as Mapper<CharacterDomain, CharacterListItemView>
    }

    single(named("CHARACTER_DETAIL_VIEW_MAPPER")) {
        CharacterDetailViewMapper() as Mapper<CharacterDomain, CharacterDetailView>
    }

    viewModel { CharacterListViewModel(get(), get(named(CHARACTER_LIST_VIEW_MAPPER))) }

    viewModel { (characterId: String) ->
        CharacterDetailViewModel(
            characterId,
            get(),
            characterDetailViewMapper = get(named(CHARACTER_DETAIL_VIEW_MAPPER))
        )
    }
}
