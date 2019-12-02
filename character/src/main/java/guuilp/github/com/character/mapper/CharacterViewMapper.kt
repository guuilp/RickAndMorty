package guuilp.github.com.character.mapper

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.model.CharacterView
import guuilp.github.com.character.model.LocationCharacterView
import guuilp.github.com.character.model.OriginCharacterView
import guuilp.github.com.domain_model.character.CharacterDomain

class CharacterViewMapper : Mapper<CharacterDomain, CharacterView> {
    override fun mapToView(from: CharacterDomain) = CharacterView(
        id = from.id,
        gender = from.gender,
        imageUrl = from.imageUrl,
        location = LocationCharacterView(
            id = from.location.id,
            name = from.location.name
        ),
        name = from.name,
        origin = OriginCharacterView(
            id = from.origin.id,
            name = from.origin.name
        ),
        species = from.species,
        status = from.status,
        type = from.type
    )
}
