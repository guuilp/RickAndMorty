package guuilp.github.com.domain.interactor.character

import guuilp.github.com.domain.BaseUseCase
import guuilp.github.com.domain.model.CharacterModel
import guuilp.github.com.domain.repository.CharacterRepository

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) : BaseUseCase<List<CharacterModel>, Void?> {
    override suspend operator fun invoke(params: Void?) = characterRepository.getAllCharacters()
}