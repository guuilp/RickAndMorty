package guuilp.github.com.data.factory

import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.data_model.character.LocationCharacterEntity
import guuilp.github.com.data_model.character.OriginCharacterEntity
import guuilp.github.com.test_core.util.RandomUtil

object CharacterEntityFactory {

    fun makeList(
        quantity: Int = RandomUtil.int()
    ) = mutableListOf<CharacterEntity>().apply {
        repeat(quantity) { add(make()) }
    }

    fun make(
        id: Int = RandomUtil.int(),
        episode: List<String> = RandomUtil.stringList(),
        gender: String = RandomUtil.string(),
        image: String = RandomUtil.string(),
        location: LocationCharacterEntity = makeLocationCharacterEntity(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterEntity = makeOriginCharacterEntity(),
        species: String = RandomUtil.string(),
        status: String = RandomUtil.string(),
        type: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = CharacterEntity(
        id = id,
        episodeIdList = episode,
        gender = gender,
        imageUrl = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type,
        url = url
    )

    private fun makeLocationCharacterEntity(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = LocationCharacterEntity(name = name, id = url)

    private fun makeOriginCharacterEntity(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = OriginCharacterEntity(name = name, id = url)
}