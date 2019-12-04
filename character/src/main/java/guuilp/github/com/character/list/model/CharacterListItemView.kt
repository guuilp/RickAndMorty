package guuilp.github.com.character.list.model

import guuilp.github.com.character.common.StableItem

data class CharacterListItemView(
    val id: String,
    val imageUrl: String,
    val name: String
) : StableItem {
    override val stableId = id
}