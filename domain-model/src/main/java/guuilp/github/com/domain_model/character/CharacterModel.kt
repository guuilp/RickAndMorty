package guuilp.github.com.domain_model.character

data class CharacterModel(
    val id: String,
    val episodeIdList: List<String>,
    val gender: Gender,
    val imageUrl: String,
    val location: LocationCharacterModel,
    val name: String,
    val origin: OriginCharacterModel,
    val species: String,
    val status: Status,
    val type: String
)

data class LocationCharacterModel(
    val id: String,
    val name: String
)

data class OriginCharacterModel(
    val id: String,
    val name: String
)
