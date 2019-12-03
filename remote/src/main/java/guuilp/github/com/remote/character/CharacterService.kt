package guuilp.github.com.remote.character

import guuilp.github.com.remote.character.model.CharacterCompleteResponse
import guuilp.github.com.remote.character.model.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @GET("character")
    suspend fun getAllCharacter(): Response<CharacterCompleteResponse>

    @GET("character/{characterIds}")
    suspend fun getCharactersById(@Path("characterIds") id: String): Response<CharacterResponse>

    @GET("character")
    suspend fun filterCharacter(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?
    ): Response<CharacterCompleteResponse>
}
