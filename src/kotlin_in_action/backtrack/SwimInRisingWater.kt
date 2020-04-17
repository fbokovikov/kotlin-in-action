package kotlin_in_action.backtrack

fun main() {
    val sol = SwimInRisingWater()
    val grid = arrayOf(
        intArrayOf(0,1,2,3,4),
        intArrayOf(24,23,22,21,5),
        intArrayOf(12,13,14,15,16),
        intArrayOf(11,17,18,19,20),
        intArrayOf(10,9,8,7,6)
    )
    val result = sol.swimInWater(grid)
    print(result)
}
class SwimInRisingWater {

    fun swimInWater(grid: Array<IntArray>): Int {
        return 0
    }
}