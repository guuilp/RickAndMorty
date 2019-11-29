package guuilp.github.com.character.common

interface Mapper<in D, out V> {

    fun mapToView(from: D): V

}
