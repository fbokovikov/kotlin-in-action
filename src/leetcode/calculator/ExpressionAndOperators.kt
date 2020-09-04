package leetcode.calculator

import java.util.*

fun main() {
    val num = "000"
    val target = 0
    val res = addOperators(num, target)
    println(res)
}

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 */
fun addOperators(num: String, target: Int): List<String> {
    if (num.isEmpty()) {
        return emptyList()
    }
    val result = mutableListOf<String>()
    addOperators(1, num, target.toLong(), result)
    return result.toList()
}

private fun addOperators(idx: Int, curExpression: String, target: Long, expressions: MutableList<String>) {
    if (idx >= curExpression.length) {
        val result = evaluateString(curExpression)
        if (result == target) {
            expressions.add(curExpression)
        }
    } else {
        val prefix = curExpression.substring(0, idx)
        val postFix = curExpression.substring(idx)
        for (op in opsMap.keys) {
            addOperators(idx + 2, prefix + op + postFix, target, expressions)
        }
        var prefixIdx = prefix.lastIndex
        val str = buildString { while(prefixIdx >= 0 && prefix[prefixIdx].isDigit()) append(prefix[prefixIdx--]) }
        if (str.last() != '0') {
            addOperators(idx + 1, curExpression, target, expressions)
        }
    }
}

private fun evaluateString(num: String): Long {
    var index = 0
    val nums = Stack<Long>()
    val ops = Stack<Char>()
    fun readLong(): Long {
        var curNum: Long = Character.getNumericValue(num[index]).toLong()
        while (index + 1 < num.length && num[index + 1].isDigit()) {
            curNum = curNum * 10 + (num[++index] - '0')
        }
        return curNum
    }
    fun evalFirst() {
        val second = nums.pop()
        val first = nums.pop()
        nums.push(opsMap[ops.pop()]!!.invoke(first, second))
    }

    // 1 + 3 * 4 + 2
    while (index < num.length) {
        val curChar = num[index]
        when {
            curChar.isDigit() -> nums.push(readLong())
            curChar == '*' -> {
                index++
                nums.push(nums.pop() * readLong())
            }
            else -> {
                if (ops.isNotEmpty()) {
                    evalFirst()
                }
                ops.push(curChar)
            }
        }
        index++
    }
    if (ops.isNotEmpty()) {
        evalFirst()
    }
    return nums.pop()
}

val opsMap = mapOf(
    '+' to {a: Long, b: Long -> a + b},
    '-' to {a: Long, b: Long -> a - b},
    '*' to {a: Long, b: Long -> a * b}
)