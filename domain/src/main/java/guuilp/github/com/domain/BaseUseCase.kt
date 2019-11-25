package guuilp.github.com.domain

interface BaseUseCase<T, in Params> {
    suspend operator fun invoke(params: Params? = null): T
}