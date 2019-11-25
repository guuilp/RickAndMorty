package guuilp.github.com.data

import guuilp.github.com.data.mapper.Mapper
import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.data.model.LocationCharacterEntity
import guuilp.github.com.data.model.OriginCharacterEntity
import guuilp.github.com.data.repository.CharacterRemote
import guuilp.github.com.domain.model.CharacterModel
import guuilp.github.com.domain.model.LocationCharacterModel
import guuilp.github.com.domain.model.OriginCharacterModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class CharacterDataRepositoryTest {

    private lateinit var characterDataRepository: CharacterDataRepository

    private val characterRemote = mockk<CharacterRemote>()
    private val characterModelMapper = mockk<Mapper<CharacterEntity, CharacterModel>>()

    @Before
    fun setup() {
        characterDataRepository = CharacterDataRepository(
            characterRemote,
            characterModelMapper
        )
    }

    @Test
    fun getAllCharacters_returnsExpectedModel() = runBlockingTest {
        val expectedModel = CharacterModel(
            id = 1,
            episode = listOf(),
            gender = "male",
            image = "some-image",
            location = LocationCharacterModel(name = "name", url = "url"),
            name = "name",
            origin = OriginCharacterModel(name = "name", url = "url"),
            species = "species",
            status = "status",
            type = "type",
            url = "url"
        )

        coEvery { characterRemote.getAllCharacter() } answers {
            listOf(
                CharacterEntity(
                    id = 1,
                    episode = listOf(),
                    gender = "male",
                    image = "some-image",
                    location = LocationCharacterEntity(name = "name", url = "url"),
                    name = "name",
                    origin = OriginCharacterEntity(name = "name", url = "url"),
                    species = "species",
                    status = "status",
                    type = "type",
                    url = "url"
                )
            )
        }
        every { characterModelMapper.mapFromEntity(any()) } answers {
            expectedModel
        }

        val result = characterDataRepository.getAllCharacters()

        assertEquals(listOf(expectedModel), result)
    }

}