package guuilp.github.com.domain.common

interface BaseUseCase<T, in Params> {
    suspend operator fun invoke(params: Params? = null): T
}