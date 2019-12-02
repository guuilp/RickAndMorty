package guuilp.github.com.character.list.model

import guuilp.github.com.character.common.StableItem

data class CharacterListItemView(
    val id: String,
    val gender: String,
    val imageUrl: String,
    val location: LocationCharacterView,
    val name: String,
    val origin: OriginCharacterView,
    val species: String,
    val status: String,
    val type: String
) : StableItem {
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
