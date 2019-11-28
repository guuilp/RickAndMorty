package guuilp.github.com.character.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain_model.character.CharacterModel
import kotlinx.coroutines.launch

class CharacterViewModel(getAllCharactersUseCase: UseCase<List<CharacterModel>, Void?>) : ViewModel() {

    val characters = MutableLiveData<List<CharacterModel>>()

    init {
        viewModelScope.launch {
            characters.postValue(getAllCharactersUseCase())
        }
    }
}