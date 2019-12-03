package guuilp.github.com.domain.character.repository

import guuilp.github.com.domain_model.character.CharacterDomain

interface CharacterRepository {
    suspend fun getAllCharacters(): List<CharacterDomain>?
    suspend fun getSingleCharacter(id: String): CharacterDomain?
}