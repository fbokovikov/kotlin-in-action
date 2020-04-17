package kotlin_in_action.backtrack

fun main() {
    val board =
        arrayOf(
            charArrayOf('o','a','a','n'),
            charArrayOf('e','t','a','e'),
            charArrayOf('i','h','k','r'),
            charArrayOf('i','f','l','v')
        )
    val wordSearch = WordSearch_II()
    val words = arrayOf("oath","pea","eat","rain")
    println(wordSearch.findWords(board = board, words = words))

}

class WordSearch_II {

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        return emptyList()
    }
}