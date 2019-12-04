package guuilp.github.com.character.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    characterId: String,
    getSingleCharactersUseCase: GetSingleCharacterUseCase,
    characterDetailViewMapper: Mapper<CharacterDomain, CharacterDetailView>,
    val model: CharacterDetailModel = CharacterDetailModel()
) : ViewModel() {

    init {
        viewModelScope.launch {
            val result = getSingleCharactersUseCase.invoke(characterId)
            model.character.postValue(characterDetailViewMapper.mapToView(result))
        }
    }
}