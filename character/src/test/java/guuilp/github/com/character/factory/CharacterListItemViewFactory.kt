package guuilp.github.com.character.factory

import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.test_core.util.RandomUtil

object CharacterListItemViewFactory {

    fun make(
        id: String = RandomUtil.string(),
        image: String = RandomUtil.string(),
        name: String = RandomUtil.string()
    ) = CharacterListItemView(
        id = id,
        imageUrl = image,
        name = name
    )
}