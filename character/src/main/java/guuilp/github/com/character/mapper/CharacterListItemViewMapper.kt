package guuilp.github.com.character.mapper

import android.annotation.SuppressLint
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.model.CharacterListItemView
import guuilp.github.com.character.model.LocationCharacterView
import guuilp.github.com.character.model.OriginCharacterView
import guuilp.github.com.domain_model.character.CharacterDomain
@SuppressLint("DefaultLocale")
class CharacterListItemViewMapper : Mapper<CharacterDomain, CharacterListItemView> {
    override fun mapToView(from: CharacterDomain) = CharacterListItemView(
        id = from.id,
        gender = from.gender.capitalize(),
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
        species = from.species.capitalize(),
        status = from.status.capitalize(),
        type = from.type
    )
}
