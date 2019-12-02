package guuilp.github.com.character.factory

import guuilp.github.com.character.model.CharacterListItemView
import guuilp.github.com.character.model.LocationCharacterView
import guuilp.github.com.character.model.OriginCharacterView
import guuilp.github.com.domain_model.character.Gender
import guuilp.github.com.domain_model.character.Status
import guuilp.github.com.test_core.util.RandomUtil

object CharacterViewFactory {

    fun make(
        id: String = RandomUtil.string(),
        gender: Gender = RandomUtil.enum(Gender::class.java),
        image: String = RandomUtil.string(),
        location: LocationCharacterView = makeLocationCharacterView(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterView = makeOriginCharacterView(),
        species: String = RandomUtil.string(),
        status: Status = RandomUtil.enum(Status::class.java),
        type: String = RandomUtil.string()
    ) = CharacterListItemView(
        id = id,
        gender = gender,
        imageUrl = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type
    )

    private fun makeLocationCharacterView(
        id: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = LocationCharacterView(id = id, name = name)

    private fun makeOriginCharacterView(
        id: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = OriginCharacterView(id = id, name = name)
}