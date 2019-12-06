package guuilp.github.com.character.list.presentation

import androidx.lifecycle.MutableLiveData
import guuilp.github.com.character.common.SingleLiveEvent
import guuilp.github.com.character.list.model.CharacterListItemView

data class CharacterListModel(
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = true },
    val characters: MutableLiveData<List<CharacterListItemView>> = MutableLiveData(),
    val action: SingleLiveEvent<Action> = SingleLiveEvent()
) {
    sealed class Action {
        class ItemClick(val characterId: String) : Action()
    }
}
