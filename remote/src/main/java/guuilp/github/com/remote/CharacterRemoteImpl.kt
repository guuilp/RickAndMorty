package guuilp.github.com.remote

import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.data.repository.CharacterRemote
import guuilp.github.com.remote.mapper.EntityMapper
import guuilp.github.com.remote.model.character.CharacterResponse

class CharacterRemoteImpl(
    private val characterService: CharacterService,
    private val responseToEntityMapper: EntityMapper<CharacterResponse, CharacterEntity>
) : CharacterRemote {

    override suspend fun getAllCharacter(): List<CharacterEntity> {
        val response = characterService.getAllCharacter()
        return if(response.isSuccessful) {
            response.body()?.results?.map {
                responseToEntityMapper.mapFromRemote(it)
            } ?: emptyList()
        } else {
            emptyList()
        }
    }
}
