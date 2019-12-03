package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain_model.character.CharacterDomain

interface GetAllCharactersUseCase {
    suspend operator fun invoke(): List<CharacterDomain>
}
