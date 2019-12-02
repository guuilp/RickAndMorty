package guuilp.github.com.character.list.presentation

import androidx.lifecycle.MutableLiveData
import guuilp.github.com.character.list.model.CharacterListItemView

data class CharacterListModel(val characters: MutableLiveData<List<CharacterListItemView>> = MutableLiveData())
