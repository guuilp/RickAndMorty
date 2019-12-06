package guuilp.github.com.character.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    val characterId: String,
    val getSingleCharactersUseCase: GetSingleCharacterUseCase,
    val characterDetailViewMapper: Mapper<CharacterDomain, CharacterDetailView>,
    val model: CharacterDetailModel = CharacterDetailModel()
) : ViewModel() {

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            model.isLoading.postValue(true)
            val result = getSingleCharactersUseCase.invoke(characterId)
            model.character.postValue(characterDetailViewMapper.mapToView(result))
            model.isLoading.postValue(false)
        }
    }
}