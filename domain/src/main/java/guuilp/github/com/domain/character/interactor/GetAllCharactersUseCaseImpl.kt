package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain.character.repository.CharacterRepository

class GetAllCharactersUseCaseImpl(
    private val characterRepository: CharacterRepository
) : GetAllCharactersUseCase {

    override suspend fun invoke() =
        characterRepository.getAllCharacters() ?: emptyList()
}
