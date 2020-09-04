package kotlin_in_action.facebook.easy

fun main() {
    val ar = intArrayOf(1, 2, 2)
    println(isMonotonic(ar))
}

fun isMonotonic(array: IntArray): Boolean {
    var increasing = true
    var decreasing = true
    for (i in 0..array.size - 2) {
        if (array[i] > array[i + 1]) {
            increasing = false
        }
        if (array[i] < array[i + 1]) {
            decreasing = false
        }
    }
    return increasing || decreasing
}

fun isMonotonic2(array: IntArray): Boolean {
    val direction = array.last() - array.first()
    for (i in 0..array.size - 2) {
        val diff = array[i + 1] - array[i]
        if (direction == 0 && diff != 0)
            return false
        if (direction > 0 && diff < 0)
            return false
        if (direction < 0 &&  diff > 0)
            return false
    }
    return true
}
