package guuilp.github.com.data.repository

import guuilp.github.com.data.model.CharacterEntity

interface CharacterRemote {
    suspend fun getAllCharacter(): List<CharacterEntity>
}