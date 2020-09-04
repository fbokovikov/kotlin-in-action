package kotlin_in_action.facebook.medium

fun main() {
    val nums = intArrayOf(3,2,1,5,6,4)
    println(findKthLargest(nums, 2))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    return quickSelect(nums, 0, nums.size - 1, nums.size - k + 1)
}

fun quickSelect(nums: IntArray, from: Int, to: Int, k: Int): Int {
    val pivotIndex = partition(nums, from, to)
    return when {
        pivotIndex == k - 1-> nums[pivotIndex]
        pivotIndex > k - 1 -> quickSelect(nums, from, pivotIndex - 1, k)
        else -> quickSelect(nums, pivotIndex + 1, to, k)
    }
}

fun partition(nums: IntArray, from: Int, to: Int, pivot: Int = nums[to]): Int {
    var i = from - 1
    for (j in from..to) {
        if (nums[j] < pivot) {
            i++
            swap(nums, i, j)
        }
    }
    swap(nums, i + 1, to)
    return i + 1
}

// <= pivot and >= pivot
fun partition2(nums: IntArray, from: Int, to: Int, pivot: Int): Int {
    var left = from - 1
    var right = to + 1
    while (true) {
        do {
            left++
        } while (nums[left] < pivot)
        do {
            right--
        } while (nums[right] > pivot)
        if (left >= right)
            return right
        swap(nums, left, right)
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    val buf = nums[i]
    nums[i] = nums[j]
    nums[j] = buf
}