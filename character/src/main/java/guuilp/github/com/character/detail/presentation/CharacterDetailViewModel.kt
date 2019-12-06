package guuilp.github.com.character.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.common.executeWithLoading
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import kotlinx.coroutines.launch

class CharacterDetailViewModel(
    val characterId: String,
    private val getSingleCharactersUseCase: GetSingleCharacterUseCase,
    val characterDetailViewMapper: Mapper<CharacterDomain, CharacterDetailView>,
    val model: CharacterDetailModel = CharacterDetailModel()
) : ViewModel() {

    init {
        viewModelScope.launch {
            executeWithLoading(model.isLoading) {
                loadCharacterDetail()
            }
        }
    }

    private suspend fun loadCharacterDetail() {
        val result = getSingleCharactersUseCase.invoke(characterId)
        model.character.postValue(characterDetailViewMapper.mapToView(result))
    }
}
