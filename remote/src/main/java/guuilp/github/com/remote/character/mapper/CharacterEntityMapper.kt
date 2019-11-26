package guuilp.github.com.remote.character.mapper

import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.data_model.character.LocationCharacterEntity
import guuilp.github.com.data_model.character.OriginCharacterEntity
import guuilp.github.com.remote.common.EntityMapper
import guuilp.github.com.remote.character.model.CharacterResponse

class CharacterEntityMapper :
    EntityMapper<CharacterResponse, CharacterEntity> {
    override fun mapFromRemote(from: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            id = from.id,
            episode = from.episode,
            gender = from.gender,
            image = from.image,
            location = LocationCharacterEntity(
                name = from.location.name,
                url = from.location.url
            ),
            name = from.name,
            origin = OriginCharacterEntity(
                name = from.origin.name,
                url = from.origin.url
            ),
            species = from.species,
            status = from.status,
            type = from.type,
            url = from.url
        )
    }
}