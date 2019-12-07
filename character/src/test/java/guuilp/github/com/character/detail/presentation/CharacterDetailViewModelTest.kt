package guuilp.github.com.character.detail.presentation

import guuilp.github.com.character.CoroutinesTestExtension
import guuilp.github.com.character.InstantTaskExecutorExtension
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.character.factory.CharacterDetailViewFactory
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
import guuilp.github.com.test_core.util.RandomUtil
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
@Extensions(
    ExtendWith(InstantTaskExecutorExtension::class),
    ExtendWith(CoroutinesTestExtension::class)
)
class CharacterDetailViewModelTest(private val testDispatcher: TestCoroutineDispatcher) {

    private lateinit var characterDetailViewModel: CharacterDetailViewModel
    private val characterId = RandomUtil.string()
    private val getSingleCharactersUseCase = mockk<GetSingleCharacterUseCase>()
    private val characterDetailViewMapper = mockk<Mapper<CharacterDomain, CharacterDetailView>>()

    @BeforeEach
    fun setUp() {
        prepareScenario()

        characterDetailViewModel = CharacterDetailViewModel(
            characterId = characterId,
            getSingleCharactersUseCase = getSingleCharactersUseCase,
            characterDetailViewMapper = characterDetailViewMapper
        )
    }

    @Test
    fun bla() = testDispatcher.runBlockingTest {
        assertNotNull(characterDetailViewModel.model.character)
    }

    private fun prepareScenario() {
        coEvery { getSingleCharactersUseCase(any()) } answers { CharacterDomainFactory.make() }
        every { characterDetailViewMapper.mapToView(any()) } answers { CharacterDetailViewFactory.make() }
    }
}