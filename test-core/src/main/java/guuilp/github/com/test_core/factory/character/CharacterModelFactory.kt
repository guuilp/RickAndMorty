package guuilp.github.com.test_core.factory.character

import guuilp.github.com.domain_model.character.CharacterModel
import guuilp.github.com.domain_model.character.LocationCharacterModel
import guuilp.github.com.domain_model.character.OriginCharacterModel
import guuilp.github.com.test_core.util.RandomUtil

object CharacterModelFactory {

    fun makeList(
        quantity: Int = RandomUtil.int()
    ) = mutableListOf<CharacterModel>().apply {
        repeat(quantity) { add(make()) }
    }

    fun make(
        id: Int = RandomUtil.int(),
        episode: List<String> = RandomUtil.stringList(),
        gender: String = RandomUtil.string(),
        image: String = RandomUtil.string(),
        location: LocationCharacterModel = makeLocationCharacterEntity(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterModel = makeOriginCharacterEntity(),
        species: String = RandomUtil.string(),
        status: String = RandomUtil.string(),
        type: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = CharacterModel(
        id = id,
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

    private fun makeLocationCharacterEntity(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = LocationCharacterModel(name = name, url = url)

    private fun makeOriginCharacterEntity(
        name: String = RandomUtil.string(),
        url: String = RandomUtil.string()
    ) = OriginCharacterModel(name = name, url = url)
}