package guuilp.github.com.character.list.mapper

import android.annotation.SuppressLint
import guuilp.github.com.character.common.Mapper
import guuilp.github.com.character.list.model.CharacterListItemView
import guuilp.github.com.domain_model.character.CharacterDomain
@SuppressLint("DefaultLocale")
class CharacterListItemViewMapper : Mapper<CharacterDomain, CharacterListItemView> {

    override fun mapToView(from: CharacterDomain) = CharacterListItemView(
        id = from.id,
        imageUrl = from.imageUrl,
        name = from.name
    )
}
