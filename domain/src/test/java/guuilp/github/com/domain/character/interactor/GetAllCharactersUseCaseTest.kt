package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class GetAllCharactersUseCaseTest {

    private val characterRepository = mockk<CharacterRepository>()
    private val getAllCharactersUseCase = GetAllCharactersUseCaseImpl(characterRepository)

    @Test
    fun getAllCharactersUseCase_returnsCorrectList() = runBlockingTest {
        val expected = CharacterDomainFactory.makeList(1)
        coEvery { characterRepository.getAllCharacters() } answers { expected }

        val result = getAllCharactersUseCase()

        assertEquals(expected, result)
    }
}