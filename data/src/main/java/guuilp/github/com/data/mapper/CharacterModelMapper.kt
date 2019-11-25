package guuilp.github.com.data.mapper

import guuilp.github.com.data.model.CharacterEntity
import guuilp.github.com.data.model.LocationCharacterEntity
import guuilp.github.com.data.model.OriginCharacterEntity
import guuilp.github.com.domain.model.CharacterModel
import guuilp.github.com.domain.model.LocationCharacterModel
import guuilp.github.com.domain.model.OriginCharacterModel

class CharacterModelMapper : Mapper<CharacterEntity, CharacterModel> {
    override fun mapFromEntity(from: CharacterEntity): CharacterModel {
        return CharacterModel(
            id = from.id,
            episode = from.episode,
            gender = from.gender,
            image = from.image,
            location = LocationCharacterModel(
                name = from.location.name,
                url = from.location.url
            ),
            name = from.name,
            origin = OriginCharacterModel(
                name = from.origin.name,
                url = from.origin.url
            ),
            species = from.species,
            status = from.status,
            type = from.type,
            url = from.url
        )
    }

    override fun mapToEntity(from: CharacterModel): CharacterEntity {
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
