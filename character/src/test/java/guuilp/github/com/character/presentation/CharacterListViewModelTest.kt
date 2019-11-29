package guuilp.github.com.character.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain_model.character.CharacterModel
import guuilp.github.com.test_core.factory.character.CharacterModelFactory
import guuilp.github.com.test_core.util.CoroutinesTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CharacterListViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()
    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    private lateinit var characterListViewModel: CharacterListViewModel
    private val getAllCharactersUseCase = mockk<UseCase<List<CharacterModel>, Void?>>()

    @Before
    fun setup() {
        coEvery { getAllCharactersUseCase() } answers { CharacterModelFactory.makeList() }
        characterListViewModel = CharacterListViewModel(getAllCharactersUseCase)
    }

    @Test
    fun getCharacters() = coroutinesRule.testDispatcher.runBlockingTest {
        assertNotNull(characterListViewModel.characters.value)
    }
}
