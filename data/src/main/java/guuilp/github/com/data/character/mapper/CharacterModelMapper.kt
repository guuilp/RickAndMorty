package guuilp.github.com.data.character.mapper

import guuilp.github.com.data.common.Mapper
import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.data_model.character.LocationCharacterEntity
import guuilp.github.com.data_model.character.OriginCharacterEntity
import guuilp.github.com.domain_model.character.*

class CharacterModelMapper : Mapper<CharacterEntity, CharacterDomain> {
    override fun mapFromEntity(from: CharacterEntity): CharacterDomain {
        return CharacterDomain(
            id = from.id,
            episodeIdList = from.episodeIdList,
            gender = from.gender,
            imageUrl = from.imageUrl,
            location = LocationCharacterDomain(
                id = from.location.id,
                name = from.location.name
            ),
            name = from.name,
            origin = OriginCharacterDomain(
                id = from.origin.id,
                name = from.origin.name
            ),
            species = from.species,
            status = from.status,
            type = from.type
        )
    }

    override fun mapToEntity(from: CharacterDomain): CharacterEntity {
        return CharacterEntity(
            id = from.id,
            episodeIdList = from.episodeIdList,
            gender = from.gender,
            imageUrl = from.imageUrl,
            location = LocationCharacterEntity(
                id = from.location.id,
                name = from.location.name
            ),
            name = from.name,
            origin = OriginCharacterEntity(
                id = from.origin.id,
                name = from.origin.name
            ),
            species = from.species,
            status = from.status,
            type = from.type
        )
    }
}
