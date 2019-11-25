package guuilp.github.com.domain.model

data class CharacterModel(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: LocationCharacterModel,
    val name: String,
    val origin: OriginCharacterModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationCharacterModel(
    val name: String,
    val url: String
)

data class OriginCharacterModel(
    val name: String,
    val url: String
)