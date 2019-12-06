package guuilp.github.com.character.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import kotlinx.coroutines.launch

class CharacterListViewModel(
    val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val characterListItemViewMapper: Mapper<CharacterDomain, CharacterListItemView>,
    val model: CharacterListModel = CharacterListModel()
) : ViewModel() {

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            model.isLoading.postValue(true)

            val result = getAllCharactersUseCase().map { characterListItemViewMapper.mapToView(it) }
            model.characters.postValue(result)

            model.isLoading.postValue(false)
        }
    }

    fun itemClick(characterId: String) {
        model.action.postValue(CharacterListModel.Action.ItemClick(characterId))
    }
}
