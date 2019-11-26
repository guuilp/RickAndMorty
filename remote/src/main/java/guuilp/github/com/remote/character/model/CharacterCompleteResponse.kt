package guuilp.github.com.remote.character.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import guuilp.github.com.remote.common.InfoResponse

@JsonClass(generateAdapter = true)
data class CharacterCompleteResponse(
    @Json(name = "info") val infoResponse: InfoResponse,
    @Json(name = "results") val results: List<CharacterResponse>
)

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "created") val created: String,
    @Json(name = "episode") val episode: List<String>,
    @Json(name = "gender") val gender: String,
    @Json(name = "id") val id: Int,
    @Json(name = "image") val image: String,
    @Json(name = "location") val location: LocationCharacterResponse,
    @Json(name = "name") val name: String,
    @Json(name = "origin") val origin: OriginCharacterResponse,
    @Json(name = "species") val species: String,
    @Json(name = "status") val status: String,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String
)

@JsonClass(generateAdapter = true)
data class LocationCharacterResponse(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)

@JsonClass(generateAdapter = true)
data class OriginCharacterResponse(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)
