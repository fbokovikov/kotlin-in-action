package kotlin_in_action.amazon.easy

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSum(nums, target).toList())
}

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsWithIndices = hashMapOf<Int, Int>()
    for ((index, num) in nums.withIndex()) {
        if ((target - num) in numsWithIndices) {
            return intArrayOf(numsWithIndices[target - num]!!, index)
        }
        numsWithIndices[num] = index
    }
    throw IllegalStateException("Pair for target: $target not found!")
}