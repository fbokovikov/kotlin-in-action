package kotlin_in_action.backtrack

fun main() {
    val board =
        arrayOf(
            charArrayOf('A','B','C','E'),
            charArrayOf('S','F','C','S'),
            charArrayOf('A','D','E','E')
        )
    val wordSearch = WordSearch()
    println(wordSearch.exist(board = board, word = "ABCCED"))
    println(wordSearch.exist(board = board, word = "SEE"))
    println(wordSearch.exist(board = board, word = "ABCB"))
}

class WordSearch {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size

        fun findWord(board: Array<CharArray>, visited: Array<IntArray>, x: Int, y: Int, index: Int): Boolean {
            if (index == word.length) {
                return true
            } else {
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    return false
                }
                if (board[x][y] != word[index] || visited[x][y] == 1) {
                    return false
                }
                visited[x][y] = 1
                val result = findWord(board, visited, x - 1, y, index + 1)
                        || findWord(board, visited, x + 1, y, index + 1)
                        || findWord(board, visited, x, y - 1, index + 1)
                        || findWord(board, visited, x, y + 1, index + 1)
                visited[x][y] = 0
                return result
            }
        }

        val visited = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (findWord(board, visited, i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }
}