package guuilp.github.com.domain_model.character

data class CharacterDomain(
    val id: String,
    val episodeIdList: List<String>,
    val gender: String,
    val imageUrl: String,
    val location: LocationCharacterDomain,
    val name: String,
    val origin: OriginCharacterDomain,
    val species: String,
    val status: String,
    val type: String
)

data class LocationCharacterDomain(
    val id: String,
    val name: String
)

data class OriginCharacterDomain(
    val id: String,
    val name: String
)
