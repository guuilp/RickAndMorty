package guuilp.github.com.remote.mapper

import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.data.model.LocationCharacterEntity
import guuilp.github.com.data.model.OriginCharacterEntity
import guuilp.github.com.remote.model.character.CharacterResponse

class CharacterEntityMapper : EntityMapper<CharacterResponse, CharacterEntity> {
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