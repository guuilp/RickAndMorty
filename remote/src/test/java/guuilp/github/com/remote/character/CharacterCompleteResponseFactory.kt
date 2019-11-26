package guuilp.github.com.remote.character

import com.squareup.moshi.Json
import guuilp.github.com.remote.character.model.CharacterCompleteResponse
import guuilp.github.com.remote.character.model.CharacterResponse
import guuilp.github.com.remote.character.model.LocationCharacterResponse
import guuilp.github.com.remote.character.model.OriginCharacterResponse
import guuilp.github.com.remote.common.InfoResponse
import guuilp.github.com.test_core.util.RandomUtil

object CharacterCompleteResponseFactory {

    fun make(
        infoResponse: InfoResponse = makeInfoResponse(),
        results: List<CharacterResponse> = makeCharacterResponseList(RandomUtil.int())
    ) = CharacterCompleteResponse(
        infoResponse = infoResponse,
        results = results
    )

    fun makeInfoResponse(
        count: Int = RandomUtil.int(),
        next: String = RandomUtil.string(),
        pages: Int = RandomUtil.int(),
        prev: String = RandomUtil.string()
    ) = InfoResponse(
        count = count,
        next = next,
        pages = pages,
        prev = prev
    )

    fun makeCharacterResponseList(
        quantity: Int = RandomUtil.int()
    ) = mutableListOf<CharacterResponse>().apply {
        repeat(quantity) { add(makeCharacterResponse()) }
    }

    fun makeCharacterResponse(
        id: Int = RandomUtil.int(),
        created: String = RandomUtil.string(),
        episode: List<String> = RandomUtil.stringList(),
        gender: String = RandomUtil.string(),
        image: String = RandomUtil.string(),
        location: LocationCharacterResponse = makeLocationCharacterResponse(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterResponse = makeOriginCharacterResponse(),
        species: String = RandomUtil.string(),
        status: String = RandomUtil.string(),
        type: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = CharacterResponse(
        id = id,
        created = created,
        episode = episode,
        gender = gender,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )

    private fun makeLocationCharacterResponse(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = LocationCharacterResponse(name = name, url = url)

    private fun makeOriginCharacterResponse(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = OriginCharacterResponse(name = name, url = url)
}