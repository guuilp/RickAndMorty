package guuilp.github.com.data.character.repository

import guuilp.github.com.data_model.character.CharacterEntity

interface CharacterRemote {
    suspend fun getAllCharacter(): List<CharacterEntity>
}