package guuilp.github.com.data.character

import guuilp.github.com.data.character.CharacterDataRepository
import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data.factory.CharacterEntityFactory
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.domain_model.character.CharacterModel
import guuilp.github.com.test_core.factory.character.CharacterModelFactory
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CharacterDataRepositoryTest {

    private val characterRemote = mockk<CharacterRemote>()
    private val characterModelMapper = mockk<Mapper<CharacterEntity, CharacterModel>>()
    private val characterDataRepository =
        CharacterDataRepository(
            characterRemote,
            characterModelMapper
        )

    @Test
    fun getAllCharacters_returnsExpectedModel() = runBlockingTest {
        val expectedModel = CharacterModelFactory.make()

        prepareScenario(
            remoteResult = CharacterEntityFactory.makeList(1),
            mapperResult = expectedModel
        )

        val result = characterDataRepository.getAllCharacters()

        assertEquals(listOf(expectedModel), result)
    }

    private fun prepareScenario(
        remoteResult: List<CharacterEntity> = CharacterEntityFactory.makeList(1),
        mapperResult: CharacterModel = CharacterModelFactory.make()
    ) {
        coEvery { characterRemote.getAllCharacter() } answers { remoteResult }
        every { characterModelMapper.mapFromEntity(any()) } answers { mapperResult }
    }

}