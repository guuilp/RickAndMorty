package guuilp.github.com.remote.character.mapper

import guuilp.github.com.data_model.character.CharacterEntity
import guuilp.github.com.data_model.character.LocationCharacterEntity
import guuilp.github.com.data_model.character.OriginCharacterEntity
import guuilp.github.com.remote.character.model.CharacterResponse
import guuilp.github.com.remote.common.EntityMapper

private const val URL_DELIMITER = "/"

class CharacterEntityMapper :
    EntityMapper<CharacterResponse, CharacterEntity> {

    override fun mapFromRemote(from: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            id = from.id.toString(),
            episodeIdList = extractEpisodeIdList(from.episode),
            gender = from.gender,
            imageUrl = from.image,
            location = LocationCharacterEntity(
                id = extractLastParameterFromUrl(from.location.url),
                name = from.location.name
            ),
            name = from.name,
            origin = OriginCharacterEntity(
                id = extractLastParameterFromUrl(from.origin.url),
                name = from.origin.name
            ),
            species = from.species,
            status = from.status,
            type = from.type
        )
    }

    private fun extractEpisodeIdList(episodeList: List<String>) =
        episodeList.map { extractLastParameterFromUrl(it) }

    private fun extractLastParameterFromUrl(episode: String) = episode.split(URL_DELIMITER).last()

}