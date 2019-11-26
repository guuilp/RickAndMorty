package guuilp.github.com.data.common

interface Mapper<E, D> {

    fun mapFromEntity(from: E): D

    fun mapToEntity(from: D): E

}