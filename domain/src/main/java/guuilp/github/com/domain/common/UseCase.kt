package guuilp.github.com.domain.common

interface UseCase<T, in Params> {
    suspend operator fun invoke(params: Params? = null): T
}