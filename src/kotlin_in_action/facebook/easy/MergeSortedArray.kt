package kotlin_in_action.facebook.easy

fun main() {
    val nums1 = intArrayOf(1,4,8,0,0,0)
    val nums2 = intArrayOf(2, 5, 6)
    merge(nums1, 3, nums2, nums2.size)
    println(nums1.toList())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    var n1P = m - 1
    var n2P = n - 1
    var p = m + n -1

    while (n1P >= 0 && n2P >= 0) {
        nums1[p--] = if (nums1[n1P] >= nums2[n2P]) nums1[n1P--] else nums2[n2P--]
    }

    System.arraycopy(nums2, 0, nums1, 0, n2P + 1)
}