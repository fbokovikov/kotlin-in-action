package kotlin_in_action.facebook.easy

fun main() {
    val s = "deeee"
    println(validPalindrome(s))
}

fun validPalindrome(s: String): Boolean {
    var (left, right) = 0 to s.length - 1
    while (left < right) {
        if (s[left++] != s[right--]) {
            return isPalindrome(s, left, right + 1) || isPalindrome(s, left - 1, right)
        }
    }
    return true
}

private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
    var (l, r) = left to right
    while (l < r) {
        if (s[l++] != s[r--]) {
            return false
        }
    }
    return true
}