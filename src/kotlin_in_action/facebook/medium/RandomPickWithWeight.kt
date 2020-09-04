package kotlin_in_action.facebook.medium

import kotlin.random.Random

class Solution(w: IntArray) {
    private val prefixSums: IntArray = IntArray(w.size)
    private val totalSum: Int

    init {
        prefixSums[0] = w[0]
        for (i in 1 until w.size) {
            prefixSums[i] = prefixSums[i - 1] + w[i]
        }
        totalSum = prefixSums.last()
    }

    fun pickIndexLinear(): Int {
        val target = Random.nextInt(totalSum)
        for (i in prefixSums.indices) {
            if (target < prefixSums[i]) {
                return i
            }
        }
        return prefixSums.lastIndex
    }

    fun pickIndex(): Int {
        val target = Random.nextInt(totalSum)
        var left = 0
        var right = prefixSums.lastIndex
        while (left < right) {
            val middle = (left + right) / 2
            when {
                target < prefixSums[middle] -> right = middle
                target >= prefixSums[middle] -> left = middle + 1
            }
        }
        return left
    }
}