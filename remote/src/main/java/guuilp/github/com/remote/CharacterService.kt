package guuilp.github.com.remote

import guuilp.github.com.remote.model.character.CharacterListResponse
import guuilp.github.com.remote.model.character.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    @GET("character")
    suspend fun getAllCharacter(): Response<CharacterListResponse>

    @GET("character/{characterIds}")
    suspend fun getCharactersById(@Path("characterIds") ids: List<String>): Response<List<CharacterResponse>>

    @GET("character")
    suspend fun filterCharacter(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?
    ): Response<CharacterListResponse>
}
