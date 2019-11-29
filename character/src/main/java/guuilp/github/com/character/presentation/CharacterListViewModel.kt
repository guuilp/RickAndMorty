package guuilp.github.com.character.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.model.CharacterView
import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain_model.character.CharacterModel
import kotlinx.coroutines.launch

class CharacterListViewModel(
    getAllCharactersUseCase: UseCase<List<CharacterModel>, Void?>,
    characterViewMapper: Mapper<CharacterModel, CharacterView>
) : ViewModel() {

    val characters = MutableLiveData<List<CharacterView>>()

    init {
        Log.d("GLP", "Init")
        viewModelScope.launch {
            characters.postValue(getAllCharactersUseCase().map { characterViewMapper.mapToView(it) })
        }
    }
}
