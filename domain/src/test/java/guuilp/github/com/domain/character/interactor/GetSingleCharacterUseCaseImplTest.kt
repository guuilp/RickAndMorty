package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
import guuilp.github.com.test_core.util.CoroutinesTestRule
import guuilp.github.com.test_core.util.RandomUtil
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import java.lang.IllegalStateException
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

@ExperimentalCoroutinesApi
class GetSingleCharacterUseCaseImplTest {

    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    private val characterRepository = mockk<CharacterRepository>()
    private val getSingleCharacterUseCase = GetSingleCharacterUseCaseImpl(characterRepository)

    @Test
    fun getSingleCharacterUseCase_returnsSuccess() =
        coroutinesRule.testDispatcher.runBlockingTest {
            coEvery { characterRepository.getSingleCharacter(any()) } answers { CharacterDomainFactory.make() }
            val result = getSingleCharacterUseCase(RandomUtil.string())
            assertNotNull(result)
        }

    @Test
    fun getSingleCharacterUseCase_characterNull_throwsException() =
        coroutinesRule.testDispatcher.runBlockingTest {
            coEvery { characterRepository.getSingleCharacter(any()) } answers { null }
            assertFailsWith<IllegalStateException> { getSingleCharacterUseCase(RandomUtil.string()) }
        }
}