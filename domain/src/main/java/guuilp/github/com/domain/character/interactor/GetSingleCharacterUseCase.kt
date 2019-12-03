package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain_model.character.CharacterDomain

interface GetSingleCharacterUseCase {
    suspend operator fun invoke(characterId: String): CharacterDomain
}
