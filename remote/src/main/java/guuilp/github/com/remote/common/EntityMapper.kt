package guuilp.github.com.remote.common

interface EntityMapper<in M, out E> {
    fun mapFromRemote(from: M): E
}
