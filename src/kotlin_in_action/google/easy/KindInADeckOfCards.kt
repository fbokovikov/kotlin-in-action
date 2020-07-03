package kotlin_in_action.google.easy

fun main() {
    val deck = intArrayOf(1, 2, 3, 4, 4, 3, 2, 1)
    println(hasGroupsSizeX(deck))
}

/**
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *  - Each group has exactly X cards.
 *  - All the cards in each group have the same integer.
 */
fun hasGroupsSizeX(deck: IntArray): Boolean {
    val cardToFrequency = deck.asSequence().groupingBy { it }.eachCount()
    var x = cardToFrequency.values.first()
    for ((_, frequency) in cardToFrequency) {
        x = gcd(x, frequency)
    }
    return x >= 2
}

private fun gcd(m: Int, n: Int): Int {
    var mCopy = m
    var nCopy = n
    while (mCopy != nCopy) {
        if (mCopy > nCopy) {
            mCopy -= nCopy
        } else {
            nCopy -= mCopy
        }
    }
    return mCopy
}