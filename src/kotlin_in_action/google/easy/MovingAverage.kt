package kotlin_in_action.google.easy

import java.util.ArrayDeque

class MovingAverage(private val size: Int) {

    /** Initialize your data structure here. */
    private val values = ArrayDeque<Int>()
    private var sum = 0

    fun next(value: Int): Double {
        sum += value
        values.addLast(value)
        if (values.size > size) {
            sum -= values.first
            values.removeFirst()
        }
        return sum.toDouble() / values.size
    }

}