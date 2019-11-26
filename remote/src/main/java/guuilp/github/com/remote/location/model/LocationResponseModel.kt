package guuilp.github.com.remote.location.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import guuilp.github.com.remote.common.InfoResponse

@JsonClass(generateAdapter = true)
data class LocationResponseModel(
    @Json(name = "info") val infoResponse: InfoResponse,
    @Json(name = "results") val results: List<LocationResponse>
)

@JsonClass(generateAdapter = true)
data class LocationResponse(
    @Json(name = "created") val created: String,
    @Json(name = "dimension") val dimension: String,
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "residents") val residents: List<String>,
    @Json(name = "type") val type: String,
    @Json(name = "url") val url: String
)
