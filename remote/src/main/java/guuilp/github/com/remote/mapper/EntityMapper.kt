package guuilp.github.com.remote.mapper

interface EntityMapper<in M, out E> {
    fun mapFromRemote(from: M): E
}
