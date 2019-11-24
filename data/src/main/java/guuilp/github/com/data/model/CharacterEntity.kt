package guuilp.github.com.data.model

data class CharacterEntity(
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: LocationCharacterEntity,
    val name: String,
    val origin: OriginCharacterEntity,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class LocationCharacterEntity(
    val name: String,
    val url: String
)

data class OriginCharacterEntity(
    val name: String,
    val url: String
)