package kotlin_in_action.facebook.medium

fun main() {
    val A = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(-1, 0, 3)
    )

    val B = arrayOf(
        intArrayOf(7, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1)
    )

    val result = multiply(A, B)
    for (i in result.indices) {
        for (j in result[0].indices) {
            print("${result[i][j]} ")
            if (j == result[0].lastIndex) {
                println()
            }
        }
    }
}

/**
In numerical analysis and scientific computing, a sparse matrix or sparse array is a matrix in which most of the
elements are zero. By contrast, if most of the elements are nonzero, then the matrix is considered dense.
The number of zero-valued elements divided by the total number of elements (e.g., m × n for an m × n matrix) is
called the sparsity of the matrix (which is equal to 1 minus the density of the matrix). Using those definitions,
a matrix will be sparse when its sparsity is greater than 0.5.
*/
fun multiply(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val m = A.lastIndex
    val n = if (m >= 0) A[m].lastIndex else 0
    val l = if (n >= 0) B[0].lastIndex else 0

    val result = Array(m + 1) { IntArray(l + 1) }
    for (i in 0..m) {
        for (j in 0..l) {
            for (k in 0..n) {
                if (A[i][k] != 0 && B[k][j] != 0) {
                    result[i][j] += A[i][k] * B[k][j]
                }
            }
        }
    }
    return result
}