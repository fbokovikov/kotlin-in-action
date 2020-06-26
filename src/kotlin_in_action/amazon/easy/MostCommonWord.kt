package kotlin_in_action.amazon.easy

import java.lang.IllegalStateException

val DELIMITERS = arrayOf("!", "?", "'", ";", ".", " ", ",")

fun main() {
    val  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = arrayOf("hit")
    print(mostCommonWord(paragraph, banned))
}

/**
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.
 * Words in the paragraph are not case sensitive.  The answer is in lowercase.
 */
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