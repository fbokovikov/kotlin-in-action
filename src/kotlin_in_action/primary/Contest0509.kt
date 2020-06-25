package kotlin_in_action.primary

fun main() {
    val n = 7
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(2, 6)
    )
    val hasApples = listOf(false, false, true, false, true, true, false)
    println(minTime(n, edges, hasApples))
}

fun buildArray(target: IntArray, n: Int): List<String> {
    val result = mutableListOf<String>()
    var targetIndex = 0
    for (i in 1..n) {
        result.add("Push")
        if (target[targetIndex] == i) {
            targetIndex++
        } else {
            result.add("Pop")
        }
        if (targetIndex == target.size) {
            break
        }
    }
    return result
}

fun countTriplets(arr: IntArray): Int {
    val n = arr.size
    val xorArr = IntArray(n)
    xorArr[0] = arr[0]
    for (i in 1 until n) {
        xorArr[i] = xorArr[i - 1] xor arr[i]
    }
    var counter = 0
    for (i in arr.indices) {
        for (j in i until n) {
            for (k in j + 1 until n) {
                val leftXorSum = xorArr[j] + if (i > 0) xorArr[i - 1] else 0
                val rightXorSum = xorArr[k] + xorArr[j]
                if (leftXorSum == rightXorSum) {
                    counter++
                }
            }
        }
    }
    return counter
}

fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
    val times = hashMapOf(0 to 0)
    val parents = hashMapOf<Int, Int>()
    edges.forEach { it.run { times[it[1]] = times[it[0]]!! + 1; parents[it[1]] = it[0] }}
    val visited = hashSetOf(0)
    var result = 0
    for (i in 0 until n) {
        if (hasApple[i]) {
            var parent = parents[i]
            while (parent != null) {
                if (parent in visited) {
                    result += 2 * (times[i]!! - times[parent]!!)
                    break
                }
                visited.add(parent)
                parent = parents[parent]
            }
            visited.add(i)
        }
    }
    return result
}