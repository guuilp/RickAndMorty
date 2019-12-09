package guuilp.github.com.character.detail.presentation

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.character.factory.CharacterDetailViewFactory
import guuilp.github.com.domain.character.interactor.GetSingleCharacterUseCase
import guuilp.github.com.domain_model.character.CharacterDomain
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
import guuilp.github.com.test_core.util.RandomUtil
import guuilp.github.com.test_core_android.common.CoroutinesTestExtension
import guuilp.github.com.test_core_android.common.InstantTaskExecutorExtension
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@ExperimentalCoroutinesApi
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Extensions(
    ExtendWith(InstantTaskExecutorExtension::class),
    ExtendWith(CoroutinesTestExtension::class)
)
class CharacterDetailViewModelTest(private val testDispatcher: TestCoroutineDispatcher) {

    private lateinit var characterDetailViewModel: CharacterDetailViewModel
    private val characterId = RandomUtil.string()
    private val getSingleCharactersUseCase = mockk<GetSingleCharacterUseCase>()
    private val characterDetailViewMapper = mockk<Mapper<CharacterDomain, CharacterDetailView>>()
    private val characterDetailView = CharacterDetailViewFactory.make()

    @BeforeEach
    fun setUp() {
        prepareScenario()

        characterDetailViewModel = CharacterDetailViewModel(
            characterId = characterId,
            getSingleCharactersUseCase = getSingleCharactersUseCase,
            characterDetailViewMapper = characterDetailViewMapper
        )
    }

    @DisplayName("On CharacterDetailViewModel init, loading should be false")
    @Test
    fun initLoadCharacterDetail_loadingFalse() = testDispatcher.runBlockingTest {
        Assertions.assertTrue(characterDetailViewModel.model.isLoading.value == false)
    }

    @DisplayName("On CharacterDetailViewModel init, the character should be correctly set")
    @Test
    fun initLoadCharacterDetail_correctCharacterSet() = testDispatcher.runBlockingTest {
        Assertions.assertEquals(characterDetailView, characterDetailViewModel.model.character.value)
    }

    private fun prepareScenario(
        getSingleCharacterResult: CharacterDomain = CharacterDomainFactory.make(),
        mapToViewResult: CharacterDetailView = characterDetailView
    ) {
        coEvery { getSingleCharactersUseCase(any()) } answers { getSingleCharacterResult }
        every { characterDetailViewMapper.mapToView(any()) } answers { mapToViewResult }
    }
}
