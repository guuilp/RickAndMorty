package guuilp.github.com.data.character

import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data.factory.CharacterEntityFactory
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.domain_model.character.CharacterDomain
import guuilp.github.com.test_core.factory.character.CharacterDomainFactory
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
    private val characterModelMapper = mockk<Mapper<CharacterEntity, CharacterDomain>>()
    private val characterDataRepository =
        CharacterDataRepository(
            characterRemote,
            characterModelMapper
        )

    @Test
    fun getAllCharacters_returnsExpectedModel() = runBlockingTest {
        val expectedModel = CharacterDomainFactory.make()

        prepareScenario(
            remoteResult = CharacterEntityFactory.makeList(1),
            mapperResult = expectedModel
        )

        val result = characterDataRepository.getAllCharacters()

        assertEquals(listOf(expectedModel), result)
    }

    private fun prepareScenario(
        remoteResult: List<CharacterEntity> = CharacterEntityFactory.makeList(1),
        mapperResult: CharacterDomain = CharacterDomainFactory.make()
    ) {
        coEvery { characterRemote.getAllCharacters() } answers { remoteResult }
        every { characterModelMapper.mapFromEntity(any()) } answers { mapperResult }
    }

}