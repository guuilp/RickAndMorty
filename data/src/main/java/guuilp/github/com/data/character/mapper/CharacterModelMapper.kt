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
            gender = mapGender(from.gender),
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
            status = mapStatus(from.status),
            type = from.type
        )
    }

    private fun mapGender(gender: String) = when (gender.toLowerCase()) {
        "male" -> Gender.MALE
        "female" -> Gender.FEMALE
        "genderless" -> Gender.GENDERLESS
        "unknown" -> Gender.UNKNOWN
        else -> Gender.UNKNOWN
    }

    private fun mapGender(gender: Gender) = when (gender) {
        Gender.MALE -> "male"
        Gender.FEMALE -> "female"
        Gender.GENDERLESS -> "genderless"
        Gender.UNKNOWN -> "unknown"
        else -> "unknown"
    }

    private fun mapStatus(status: String) = when (status.toLowerCase()) {
        "alive" -> Status.ALIVE
        "dead" -> Status.DEAD
        "unknown" -> Status.UNKNOWN
        else -> Status.UNKNOWN
    }

    private fun mapStatus(status: Status) = when (status) {
        Status.ALIVE -> "alive"
        Status.DEAD -> "dead"
        Status.UNKNOWN -> "unknown"
        else -> "unknown"
    }

    override fun mapToEntity(from: CharacterDomain): CharacterEntity {
        return CharacterEntity(
            id = from.id,
            episodeIdList = from.episodeIdList,
            gender = mapGender(from.gender),
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
            status = mapStatus(from.status),
            type = from.type
        )
    }
}
