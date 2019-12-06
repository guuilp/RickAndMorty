package guuilp.github.com.character.common

import androidx.lifecycle.MutableLiveData

suspend fun executeWithLoading(
    isLoading: MutableLiveData<Boolean>,
    block: suspend () -> Unit
) {
    isLoading.postValue(true)
    block()
    isLoading.postValue(false)
}