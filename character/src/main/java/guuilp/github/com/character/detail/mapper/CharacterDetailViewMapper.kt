package guuilp.github.com.character.detail.mapper

import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.character.detail.model.LocationCharacterView
import guuilp.github.com.character.detail.model.OriginCharacterView
import guuilp.github.com.domain_model.character.CharacterDomain

class CharacterDetailViewMapper : Mapper<CharacterDomain, CharacterDetailView> {
    override fun mapToView(from: CharacterDomain) = CharacterDetailView(
        id = from.id,
        episodeIdList = from.episodeIdList.map { "Episódio $it" },
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
        type = from.status
    )
}
