package guuilp.github.com.data.character.repository

import guuilp.github.com.data_model.character.CharacterEntity

interface CharacterRemote {
    suspend fun getAllCharacters(): List<CharacterEntity>?
    suspend fun getSingleCharacter(id: String): CharacterEntity?
}