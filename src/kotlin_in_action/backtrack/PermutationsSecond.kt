package kotlin_in_action.backtrack

fun main(args: Array<String>) {
    val solution = PermutationsSecond()
    val nums = intArrayOf(1, 1, 1, 2)
    println(solution.permuteUnique(nums))
}

class PermutationsSecond {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val permutations = arrayListOf<List<Int>>()

        fun localPermuteUnique(currentSequence: List<Int>, remaining: List<Int>): Unit {
            if (remaining.isEmpty()) {
                permutations.add(currentSequence)
            } else {
                for ((idx, curValue) in remaining.withIndex()) {
                    if (idx == 0 || (remaining[idx] != remaining[idx - 1])) {
                        localPermuteUnique(currentSequence + curValue, remaining - curValue)
                    }
                }
            }
        }

        localPermuteUnique(arrayListOf(), nums.sorted())
        return permutations
    }
}