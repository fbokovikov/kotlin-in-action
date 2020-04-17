package kotlin_in_action.sorting

fun bubbleSort(array: Array<Int>) {
    val n = array.size
    for (i in 0 until n) {
        for (j in 0 until n - i - 1) {
            if (array[j] > array[j + 1]) {
                val buf = array[j + 1]
                array[j + 1] = array[j]
                array[j] = buf
            }
        }
    }
}

fun main() {
    val array = arrayOf(1, 3, 4, 2, 9, 5, 8, 7, 0, 6)
    bubbleSort(array)
    print(array.toList())
}