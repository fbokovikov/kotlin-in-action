package kotlin_in_action.facebook.easy

fun main() {
    val num1 = "555"
    val num2 = "9999"
    println(addStrings(num1, num2))
}

fun addStrings(num1: String, num2: String): String {
    var m = num1.length - 1
    var n = num2.length - 1
    var carry = 0

    return buildString {
        while (m >= 0 || n >= 0) {
            val mDigit = if (m >= 0) num1[m--] - '0' else 0
            val nDigit = if (n >= 0) num2[n--] - '0' else 0
            append((mDigit + nDigit + carry) % 10)
            carry = (mDigit + nDigit + carry) / 10
        }
        if (carry > 0)
            append(carry)
    }.reversed()
}