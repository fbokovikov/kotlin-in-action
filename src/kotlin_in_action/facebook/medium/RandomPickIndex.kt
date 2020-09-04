package kotlin_in_action.facebook.medium

class RandomPickIndex(nums: IntArray) {
    private val numToIndexes = nums.withIndex().groupBy ({ it.value },  { it.index })
    fun pick(target: Int): Int = numToIndexes[target]?.random() ?: error("$target not found")
}