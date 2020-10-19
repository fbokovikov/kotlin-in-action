package leetcode.hard

fun main() {
    val nums1 = intArrayOf(1, 3)
    val nums2 = intArrayOf(2)

    println(findMedianSortedArrays(nums1, nums2))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val (k, m) = nums1.size to nums2.size
    val mergedArray = IntArray(k + m)

    var pos = 0
    var (i, j) = 0 to 0

    while (i < k || j < m) {
        if (j >= m) {
            mergedArray[pos++] = nums1[i++]
        } else if (i >= k) {
            mergedArray[pos++] = nums2[j++]
        } else {
            mergedArray[pos++] = minOf(nums1[i], nums2[j])
            if (nums1[i] <= nums2[j]) {
                i++
            } else {
                j++
            }
        }
    }

    val middle = mergedArray.size / 2
    return if (mergedArray.size % 2 == 1) {
        mergedArray[middle].toDouble()
    } else {
        (mergedArray[middle - 1] + mergedArray[middle]).toDouble() / 2
    }
}

fun findMedianSortedArraysV2(nums1: IntArray, nums2: IntArray): Double {
    return 0.0
}