package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain.common.UseCase
import guuilp.github.com.domain.character.repository.CharacterRepository
import guuilp.github.com.domain_model.character.CharacterModel

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) : UseCase<List<CharacterModel>, Void?> {
    override suspend operator fun invoke(params: Void?) = characterRepository.getAllCharacters()
}