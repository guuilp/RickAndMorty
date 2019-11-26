package guuilp.github.com.data.character

import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.domain_model.character.CharacterModel

class CharacterDataRepository(
    private val characterRemote: CharacterRemote,
    private val characterModelMapper: Mapper<CharacterEntity, CharacterModel>
) : CharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterModel> {
        return characterRemote.getAllCharacter().map { characterModelMapper.mapFromEntity(it) }
    }
}
