package guuilp.github.com.remote.character

import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.remote.character.model.CharacterResponse
import guuilp.github.com.remote.common.EntityMapper
import guuilp.github.com.remote.common.safeApiCall

class CharacterRemoteImpl(
    private val characterService: CharacterService,
    private val responseToEntityMapper: EntityMapper<CharacterResponse, CharacterEntity>
) : CharacterRemote {

    override suspend fun getAllCharacters() = safeApiCall {
        characterService.getAllCharacter()
    }?.results?.map { responseToEntityMapper.mapFromRemote(it) }

    override suspend fun getSingleCharacter(id: String): CharacterEntity? {
        val result = safeApiCall { characterService.getCharactersById(id) }

        return result?.let { responseToEntityMapper.mapFromRemote(it) }
    }
}
