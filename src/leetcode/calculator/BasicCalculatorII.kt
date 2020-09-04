package leetcode.calculator

import java.util.*

fun main() {
    val expr = "1*4-1+1*6"
    val result = calculate(expr)
    println(result)
}

val nums = LinkedList<Int>()
val ops = LinkedList<Char>()

/**
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 */
fun calculate(s: String): Int {
    var nextExecutable = false
    var curIndex = 0

    while (curIndex < s.length) {
        val ch = s[curIndex]
        if (ch.isDigit()) {
            var curNumber = s[curIndex] - '0'
            while (curIndex + 1 < s.length && s[curIndex + 1].isDigit() ) {
                curNumber = curNumber * 10 + (s[++curIndex] - '0')
            }
            nums.offerLast(curNumber)
            if (nextExecutable) {
                executeLast()
                nextExecutable = false
            }
        } else if (ch in INT_OPS.keys) {
            ops.offerLast(ch)
            if (ch in (setOf('*', '/')))
                nextExecutable = true
        }
        curIndex++
    }
    while (nums.size > 1)
        executeFirst()
    return nums.peek()
}

private fun executeFirst(): Int {
    val first = nums.pollFirst()
    val second = nums.pollFirst()
    val op = INT_OPS.getOrDefault(ops.pollFirst()) { _, _ -> 0 }
    nums.offerFirst(op.invoke(first, second))
    return nums.peekFirst()
}

private fun executeLast(): Int {
    val second = nums.pollLast()
    val first = nums.pollLast()
    val op = INT_OPS.getOrDefault(ops.pollLast()) { _, _ -> 0 }
    nums.offerLast(op.invoke(first, second))
    return nums.peekLast()
}
val INT_OPS = mapOf(
    '+' to { a: Int, b: Int -> a + b },
    '-' to { a: Int, b: Int -> a - b },
    '/' to { a: Int, b: Int -> a / b },
    '*' to { a: Int, b: Int -> a * b }
)