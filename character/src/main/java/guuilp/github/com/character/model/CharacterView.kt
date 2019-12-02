package guuilp.github.com.character.model

import guuilp.github.com.character.common.StableItem
import guuilp.github.com.domain_model.character.Gender
import guuilp.github.com.domain_model.character.Status


data class CharacterView(
    val id: String,
    val gender: Gender,
    val imageUrl: String,
    val location: LocationCharacterView,
    val name: String,
    val origin: OriginCharacterView,
    val species: String,
    val status: Status,
    val type: String
): StableItem {
    override val stableId = id
}

data class LocationCharacterView(
    val id: String,
    val name: String
)

data class OriginCharacterView(
    val id: String,
    val name: String
)
