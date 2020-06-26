package kotlin_in_action.amazon.easy

fun main() {
    val logs = arrayOf(
        "dig1 8 1 5 1",
        "let1 art can","dig2 3 6",
        "let2 own kit dig",
        "let3 art zero"
    )
    println(reorderLogFiles(logs).toList())
}

const val DELIMITER = " "

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * - Each word after the identifier will consist only of lowercase letters, or;
 * - Each word after the identifier will consist only of digits.
 *
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order. Return the final order of the logs.
 */
fun reorderLogFiles(logs: Array<String>): Array<String> {
    val letterLogs = logs.filter { isLetterLog(it) }
        .sortedWith( compareBy( { it.substringAfter(DELIMITER) }, {it.substringBefore(DELIMITER)} ))

    val digitLogs = logs.filter { isDigitLog(it) }
    return (letterLogs + digitLogs).toTypedArray()
}

private fun isLetterLog(log: String): Boolean {
    return getLogValues(log)
        .any { it.all { ch -> ch.isLetter() } }
}

private fun isDigitLog(log: String): Boolean {
    return getLogValues(log)
        .any { it.all { ch -> ch.isDigit() } }
}

private fun getLogValues(log: String): Sequence<String> {
    return log.split(DELIMITER).asSequence().drop(1)
}