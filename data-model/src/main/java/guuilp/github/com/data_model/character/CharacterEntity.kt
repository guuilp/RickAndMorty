package guuilp.github.com.data_model.character

data class CharacterEntity(
    val id: String,
    val episodeIdList: List<String>,
    val gender: String,
    val imageUrl: String,
    val location: LocationCharacterEntity,
    val name: String,
    val origin: OriginCharacterEntity,
    val species: String,
    val status: String,
    val type: String
)

data class LocationCharacterEntity(
    val id: String,
    val name: String
)

data class OriginCharacterEntity(
    val id: String,
    val name: String
)