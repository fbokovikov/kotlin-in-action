package leetcode.calculator

import java.util.*

fun main() {
    val tokens = arrayOf("2", "1", "+", "3", "*")
    println(evalRPN(tokens))
}

fun evalRPN(tokens: Array<String>): Int {
    val nums = Stack<Int>()
    tokens.forEach {
        if (it in binaryOps.keys) {
            val second = nums.pop()
            val first = nums.pop()
            val res = binaryOps[it]!!.invoke(first, second)
            nums.push(res)
        } else {
            nums.push(Integer.parseInt(it))
        }
    }
    return nums.pop()
}

val binaryOps = mapOf(
    "+" to {a: Int, b: Int -> a + b},
    "-" to {a: Int, b: Int -> a - b},
    "*" to {a: Int, b: Int -> a * b},
    "/" to {a: Int, b: Int -> a / b}
)