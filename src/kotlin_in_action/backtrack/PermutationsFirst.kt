package kotlin_in_action.backtrack

fun main(args: Array<String>) {
    val solution = PermutationFirst()
    val nums = intArrayOf(1, 2, 3, 4)
    println(solution.permute(nums))
}

class PermutationFirst {
    fun permute(nums: IntArray): List<List<Int>> {
        val permutations = arrayListOf<List<Int>>()

        fun permuteInternal(remainedNums: List<Int>, currentPermutation: List<Int>): Unit {
            if (remainedNums.isEmpty()) {
                permutations.add(currentPermutation)
            } else {
                for (num in remainedNums) {
                    permuteInternal(remainedNums - num, currentPermutation + num)
                }
            }
        }

        permuteInternal(nums.toList(), arrayListOf())

        return permutations
    }
}