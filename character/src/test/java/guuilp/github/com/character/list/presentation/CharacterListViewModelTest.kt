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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private const val CHARACTER_LIST_SIZE = 2
private const val CHARACTER_ID = "1"

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
        prepareScenario()

        characterListViewModel = CharacterListViewModel(
            getAllCharactersUseCase,
            characterViewMapper
        )
    }

    @Test
    fun init_loadAllCharacters_loadingFalse() = coroutinesRule.testDispatcher.runBlockingTest {
        assertTrue(characterListViewModel.model.isLoading.value == false)
    }

    @Test
    fun init_loadAllCharacters_correctCharacterListSize() =
        coroutinesRule.testDispatcher.runBlockingTest {
            assertEquals(2, characterListViewModel.model.characters.value?.size)
        }

    @Test
    fun itemClick_setCorrectAction() = coroutinesRule.testDispatcher.runBlockingTest {
        characterListViewModel.itemClick(CHARACTER_ID)

        val action = characterListViewModel.model.action.value

        assertTrue(action is CharacterListModel.Action.ItemClick)
        assertEquals(CHARACTER_ID, action.characterId)
    }

    private fun prepareScenario(
        getAllCharactersResult: List<CharacterDomain> = CharacterDomainFactory.makeList(quantity = CHARACTER_LIST_SIZE),
        mapToViewResult: CharacterListItemView = CharacterListItemViewFactory.make()
    ) {
        coEvery { getAllCharactersUseCase() } answers { getAllCharactersResult }
        every { characterViewMapper.mapToView(any()) } answers { mapToViewResult }
    }
}
