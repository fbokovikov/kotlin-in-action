package kotlin_in_action.interview.char_count

fun countChars(s: String): Map<Char, Int> {
    return s.groupingBy { it }.eachCount()
}

fun countCharsV3(s: String): Map<Char, Int> {
    val result: MutableMap<Char, Int> = HashMap()
    for (element in s) {
        result.merge(element, 1, Integer::sum)
    }
    return result
}