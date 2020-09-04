package kotlin_in_action.facebook.easy

fun main() {
    val a = "1010"
    val b = "111"
    println(addBinary(a, b))
}

fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1
    var offset = 0

    return buildString {
        while (i >= 0 || j >= 0) {
            val aI = if (i >= 0) a[i] - '0' else 0
            val bJ = if (j >= 0) b[j] - '0' else 0
            append((aI + bJ + offset) % 2)
            offset = (aI + bJ + offset) / 2
            j--
            i--
        }
        if (offset > 0) append(1)
    }.reversed()
}