package kotlin_in_action.google.easy

fun main() {
    val secret = "1122"
    val guess = "1222"
    println(getHint(secret, guess))
}

/**
 * Bulls - how many digits in guess match both digit and position
 * Cows - how many digits in guess match position only
 */
fun getHint(secret: String, guess: String): String {
    var cows = 0
    var bulls = 0
    val secretCharsCount = secret.groupingBy { it }.eachCount().toMutableMap()
    for (idx in guess.indices) {
        if (secret[idx] == guess[idx]) {
            cows++
            secretCharsCount[secret[idx]] = secretCharsCount[secret[idx]]!! - 1
        }
    }
    for (idx in guess.indices) {
        if (secretCharsCount.getOrDefault(guess[idx], 0) > 0 && secret[idx] != guess[idx]) {
            bulls++
            secretCharsCount[guess[idx]] = secretCharsCount[guess[idx]]!! - 1
        }
    }
    return buildString {
        append(cows)
        append("A")
        append(bulls)
        append("B")
    }
}