package guuilp.github.com.character.presentation

import androidx.lifecycle.MutableLiveData
import guuilp.github.com.character.model.CharacterListItemView

data class CharacterListModel(val characters: MutableLiveData<List<CharacterListItemView>> = MutableLiveData())
