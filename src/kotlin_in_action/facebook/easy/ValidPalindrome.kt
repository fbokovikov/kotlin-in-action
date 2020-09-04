package kotlin_in_action.facebook.easy

fun main() {
    val s = "0P0"
    println(isPalindrome(s))
}

fun isPalindrome(s: String): Boolean {
    var p1 = 0
    var p2 = s.length - 1
    while (p1 <= p2) {
        while (p1 < p2 && !isAlphaNumeric(s[p1]))
            p1++
        while (p1 < p2 && !isAlphaNumeric(s[p2]))
            p2--
        if (p1 < p2 && s[p1].toLowerCase() != s[p2].toLowerCase())
            return false
        p1++
        p2--
    }
    return true
}

private fun isAlphaNumeric(ch: Char): Boolean {
    return ch.isDigit() || ch.isLetter()
}