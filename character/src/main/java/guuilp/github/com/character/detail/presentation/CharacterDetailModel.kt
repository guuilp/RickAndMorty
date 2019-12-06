package guuilp.github.com.character.detail.presentation

import androidx.lifecycle.MutableLiveData
import guuilp.github.com.character.detail.model.CharacterDetailView

data class CharacterDetailModel(
    val character: MutableLiveData<CharacterDetailView> = MutableLiveData(),
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { value = true }
)