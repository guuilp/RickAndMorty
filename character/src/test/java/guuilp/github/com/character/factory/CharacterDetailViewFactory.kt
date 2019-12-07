package guuilp.github.com.character.factory

import guuilp.github.com.character.detail.model.CharacterDetailView
import guuilp.github.com.character.detail.model.LocationCharacterView
import guuilp.github.com.character.detail.model.OriginCharacterView
import guuilp.github.com.test_core.util.RandomUtil

object CharacterDetailViewFactory {

    fun make(
        id: String = RandomUtil.string(),
        episodeIdList: List<String> = RandomUtil.stringList(),
        gender: String = RandomUtil.string(),
        imageUrl: String = RandomUtil.string(),
        location: LocationCharacterView = makeLocationCharacterView(),
        name: String = RandomUtil.string(),
        origin: OriginCharacterView = makeOriginCharacterView(),
        species: String = RandomUtil.string(),
        status: String = RandomUtil.string(),
        type: String = RandomUtil.string()
    ) = CharacterDetailView(
        id = id,
        episodeIdList = episodeIdList,
        gender = gender,
        imageUrl = imageUrl,
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
    ) = LocationCharacterView(
        id = id,
        name = name
    )

    private fun makeOriginCharacterView(
        id: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = OriginCharacterView(
        id = id,
        name = name
    )
}