package kotlin_in_action.backtrack

fun main() {
    val solution = PermutationSequence()
    println(solution.getPermutation(9, 1))
}

class PermutationSequence {

    fun getPermutation(n: Int, k: Int): String {
        var kthPermutation = listOf<Int>()
        var permutationNum = 0
        fun localGetPermutation(curSequence: List<Int>, remaining: List<Int>) {
            if (remaining.isEmpty()) {
                permutationNum += 1
                if (permutationNum == k) {
                    kthPermutation = curSequence
                }
            } else {
                for (curValue in remaining) {
                    if (permutationNum < k) {
                        localGetPermutation(curSequence + curValue, remaining - curValue)
                    }
                }
            }
        }
        localGetPermutation(arrayListOf(), (1..n).toList())
        return kthPermutation.joinToString(separator = "")
    }
}