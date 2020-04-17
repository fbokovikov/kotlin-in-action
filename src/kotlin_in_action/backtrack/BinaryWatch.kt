package kotlin_in_action.backtrack

fun main() {
    val solution = BinaryWatch()

    for (i in 0..10) {
        println("Computing result for $i")
        println(solution.readBinaryWatch(i))
        println("\n\n")
    }
}
class BinaryWatch {

    fun readBinaryWatch(num: Int): List<String> {
        val hours = arrayListOf(8, 4, 2, 1)
        val minutes = arrayListOf(32, 16, 8, 4, 2, 1)
        val result = arrayListOf<String>()

        fun backtrack(
            array: MutableList<Int>, curResult: MutableList<Int>, curSum: Int, curPosition: Int, remainingPos: Int
        ) {
            if (remainingPos == 0) {
                curResult.add(curSum)
                return
            }
            for (pos in curPosition until array.size) {
                backtrack(array, curResult, curSum + array[pos], pos + 1, remainingPos - 1)
            }
        }
        for (i in 0..num) {
            var curHours = arrayListOf<Int>()
            val curMinutes = arrayListOf<Int>()

            backtrack(hours, curHours, 0, 0, i)
            backtrack(minutes, curMinutes, 0, 0, num - i)

            for (curHour in curHours) {
                if (curHour > 11) {
                    continue
                }
                for (curMinute in curMinutes) {
                    if (curMinute > 59) {
                        continue
                    }
                    result.add("$curHour:" + if (curMinute > 9) curMinute else "0$curMinute")
                }
            }
        }
        return result
    }
}