package kotlin_in_action.amazon.easy

import java.lang.IllegalStateException

val DELIMITERS = arrayOf("!", "?", "'", ";", ".", " ", ",")

fun main() {
    val  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    print(mostCommonWord(paragraph, banned))
}

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    return paragraph.split(delimiters = *DELIMITERS).asSequence()
        .filter { it.isNotEmpty() }
        .map { it.toLowerCase() }
        .filterNot { banned.contains(it) }
        .groupingBy { it }
        .eachCount()
        .maxBy { it.value }
        ?.key ?: throw IllegalStateException()
}