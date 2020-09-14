package leetcode.september.twenty

fun main() {
    val s = "leetcode"
    println(maxPower(s))
}

fun maxPower(s: String): Int {
    var (maxPower, curPower) = 1 to 1

    for (idx in 1 until s.length)
        if (s[idx] == s[idx - 1])
            maxPower = maxOf(maxPower, ++curPower)
        else
            curPower = 1

    return maxPower
}