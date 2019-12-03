package guuilp.github.com.data.character

import guuilp.github.com.data.character.repository.CharacterRemote
import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.domain_model.character.CharacterDomain

class CharacterDataRepository(
    private val characterRemote: CharacterRemote,
    private val characterDomainMapper: Mapper<CharacterEntity, CharacterDomain>
) : CharacterRepository {
    override suspend fun getAllCharacters(): List<CharacterDomain>? {
        return characterRemote.getAllCharacters()?.map { characterDomainMapper.mapFromEntity(it) }
    }

    override suspend fun getSingleCharacter(id: String) =
        characterRemote.getSingleCharacter(id)?.let {
            characterDomainMapper.mapFromEntity(it)
        }
}
