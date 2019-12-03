package guuilp.github.com.character.list.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.factory.CharacterListItemViewFactory
import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.domain.character.interactor.GetAllCharactersUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
import guuilp.github.com.test_core.util.CoroutinesTestRule
import io.mockk.coEvery
import io.mockk.every
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
    private val getAllCharactersUseCase = mockk<GetAllCharactersUseCase>()
    private val characterViewMapper = mockk<Mapper<CharacterDomain, CharacterListItemView>>()

    @Before
    fun setup() {
        coEvery { getAllCharactersUseCase() } answers { CharacterDomainFactory.makeList() }
        every { characterViewMapper.mapToView(any()) } answers { CharacterListItemViewFactory.make() }
        characterListViewModel = CharacterListViewModel(
            getAllCharactersUseCase,
            characterViewMapper
        )
    }

    @Test
    fun getCharacters() = coroutinesRule.testDispatcher.runBlockingTest {
        assertNotNull(characterListViewModel.model.characters.value)
    }
}
