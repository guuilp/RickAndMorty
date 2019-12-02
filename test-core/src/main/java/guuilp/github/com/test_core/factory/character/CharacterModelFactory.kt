package guuilp.github.com.test_core.factory.character

import guuilp.github.com.domain_model.character.*
import guuilp.github.com.test_core.util.RandomUtil

object CharacterModelFactory {

    fun makeList(
        quantity: Int = RandomUtil.int()
    ) = mutableListOf<CharacterModel>().apply {
        repeat(quantity) { add(make()) }
    }

    fun make(
        id: String = RandomUtil.string(),
        episode: List<String> = RandomUtil.stringList(),
        gender: Gender = RandomUtil.enum(Gender::class.java),
        image: String = RandomUtil.string(),
        location: LocationCharacterModel = makeLocationCharacterModel(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterModel = makeOriginCharacterModel(),
        species: String = RandomUtil.string(),
        status: Status = RandomUtil.enum(Status::class.java),
        type: String = RandomUtil.string()
    ) = CharacterModel(
        id = id,
        episodeIdList = episode,
        gender = gender,
        imageUrl = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type
    )

    private fun makeLocationCharacterModel(
        id: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = LocationCharacterModel(id = id, name = name)

    private fun makeOriginCharacterModel(
        id: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = OriginCharacterModel(id = id, name = name)
}