package guuilp.github.com.remote.common

import retrofit2.Response

suspend fun <T> safeApiCall(
    apiCall: suspend () -> Response<T>
): T? {
    return try {
        val response = apiCall()
        if (response.isSuccessful) response.body()
        else null
    } catch (exception: Exception) {
        println("Exception: $exception")
        null
    }
}