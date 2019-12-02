package guuilp.github.com.character.presentation

import androidx.lifecycle.MutableLiveData
import guuilp.github.com.character.model.CharacterView

data class CharacterListModel(val characters: MutableLiveData<List<CharacterView>> = MutableLiveData())
