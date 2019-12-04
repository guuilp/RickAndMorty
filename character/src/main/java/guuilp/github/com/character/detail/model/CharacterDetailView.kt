package guuilp.github.com.character.detail.model

data class CharacterDetailView(
    val id: String,
    val gender: String,
    val imageUrl: String,
    val location: LocationCharacterView,
    val name: String,
    val origin: OriginCharacterView,
    val species: String,
    val status: String,
    val type: String
)

data class LocationCharacterView(
    val id: String,
    val name: String
)

data class OriginCharacterView(
    val id: String,
    val name: String
)
