package guuilp.github.com.remote.model.episode


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import guuilp.github.com.remote.model.InfoResponse

@JsonClass(generateAdapter = true)
data class EpisodeResponseModel(
    @Json(name = "info") val infoResponse: InfoResponse,
    @Json(name = "results") val results: List<EpisodeResponse>
)

@JsonClass(generateAdapter = true)
data class EpisodeResponse(
    @Json(name = "air_date") val airDate: String,
    @Json(name = "characters") val characters: List<String>,
    @Json(name = "created") val created: String,
    @Json(name = "episode") val episode: String,
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String
)
