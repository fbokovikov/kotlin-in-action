package kotlin_in_action.facebook.easy

fun main() {
    val words = arrayOf("word","world","row")
    val order = "worldabcefghijkmnpqstuvxyz"
    println(isAlienSorted(words, order))
}

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val charToIndexMap = order.withIndex().map { it.value to it.index }.toMap()
    for (i in 0..words.size - 2) {
        val prev = words[i]
        val next = words[i + 1]
        val rangeLimit = minOf(prev.length, next.length)
        for (j in 0 until rangeLimit) {
            if (charToIndexMap.getValue(prev[j]) < charToIndexMap.getValue(next[j]))
                break
            if (charToIndexMap.getValue(prev[j]) > charToIndexMap.getValue(next[j]))
                return false
            if (j == rangeLimit - 1 && prev.length > next.length) {
                return false
            }
        }
    }
    return true
}