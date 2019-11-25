package guuilp.github.com.domain.repository

import guuilp.github.com.domain.model.CharacterModel

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterModel>
}