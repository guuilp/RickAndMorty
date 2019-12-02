package guuilp.github.com.character.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.model.CharacterView
import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import kotlinx.coroutines.launch

class CharacterListViewModel(
    getAllCharactersUseCase: UseCase<List<CharacterDomain>, Void?>,
    characterViewMapper: Mapper<CharacterDomain, CharacterView>
) : ViewModel() {

    val characters = MutableLiveData<List<CharacterView>>()

    init {
        viewModelScope.launch {
            characters.postValue(getAllCharactersUseCase().map { characterViewMapper.mapToView(it) })
        }
    }
}
