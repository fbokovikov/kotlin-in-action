package leetcode.september.twenty

fun main() {
    val candies = 10
    val numPeople = 3
    val distribution = distributeCandies(candies, numPeople)
    println(distribution.toList())
}

fun distributeCandies(candies: Int, numPeople: Int): IntArray {
    val result = IntArray(numPeople)
    var candiesRemaining = candies
    var candiesIdx = 0
    var candiesCount = 1

    while (candiesRemaining > 0) {
        if (candiesIdx == numPeople)
            candiesIdx = 0
        result[candiesIdx++] += minOf(candiesCount, candiesRemaining)
        candiesRemaining -= candiesCount++
    }

    return result
}