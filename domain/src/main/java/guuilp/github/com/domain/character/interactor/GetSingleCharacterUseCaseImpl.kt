package guuilp.github.com.domain.character.interactor

import guuilp.github.com.domain.character.repository.CharacterRepository
import java.lang.IllegalStateException

class GetSingleCharacterUseCaseImpl(
    private val characterRepository: CharacterRepository
) : GetSingleCharacterUseCase {

    override suspend fun invoke(characterId: String) =
        characterRepository.getSingleCharacter(characterId)

}
