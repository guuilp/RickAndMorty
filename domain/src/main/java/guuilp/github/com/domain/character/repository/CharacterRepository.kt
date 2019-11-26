package guuilp.github.com.domain.character.repository

import guuilp.github.com.domain_model.character.CharacterModel

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterModel>
}