package guuilp.github.com.data.character.mapper

import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.data_model.character.LocationCharacterEntity
import guuilp.github.com.data_model.character.OriginCharacterEntity
import guuilp.github.com.domain_model.character.CharacterModel
import guuilp.github.com.domain_model.character.LocationCharacterModel
import guuilp.github.com.domain_model.character.OriginCharacterModel

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
