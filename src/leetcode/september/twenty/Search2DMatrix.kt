package leetcode.september.twenty

fun main(args: Array<String>) {
    val matrix = arrayOf(
        intArrayOf(1,   3,  5,  7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 50)
    )
    val matrix2 = arrayOf(intArrayOf(3))

    println(searchMatrix(matrix2, 3))
}

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false
    }

    val row = findRow(matrix, target)
    val column = findColumn(matrix, target, row)

    return column >= 0
}

private fun findRow(matrix: Array<IntArray>, target: Int): Int {
    val n = matrix[0].size - 1
    var start = 0
    var end = matrix.size - 1

    while (start <= end) {
        val middle = (start + end) / 2
        when {
            target in matrix[middle][0]..matrix[middle][n] -> return middle
            target < matrix[middle][0] -> end = middle - 1
            else -> start = middle + 1
        }
    }

    return -1
}

private fun findColumn(matrix: Array<IntArray>, target: Int, rowPosition: Int): Int {
    if (rowPosition < 0) return -1
    val row = matrix[rowPosition]

    var start = 0
    var end = row.size - 1
    while (start <= end) {
        val middle = (start + end) / 2
        when {
            target == row[middle] -> return middle
            target > row[middle] -> start = middle + 1
            else -> end = middle - 1
        }
    }
    return -1
}