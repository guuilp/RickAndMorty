package guuilp.github.com.data

import guuilp.github.com.data.mapper.CharacterModelMapper
import guuilp.github.com.data.repository.CharacterRemote
import guuilp.github.com.domain.model.CharacterModel
import guuilp.github.com.domain.repository.CharacterRepository

class CharacterDataRepository(
    private val characterRemote: CharacterRemote,
    private val characterModelMapper: CharacterModelMapper
) : CharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterModel> {
        return characterRemote.getAllCharacter().map { characterModelMapper.mapFromEntity(it) }
    }
}
