package kotlin_in_action.structrures.trie

fun main() {
    var root = TrieNode()
    root.addWord("Hello")
    println(root.hasWord("Hello"))
    println(root.search("H..lo"))
}

data class TrieNode(private var links: MutableMap<Char, TrieNode> = HashMap(), private var isEnd: Boolean = false) {

    fun addWord(word: String) {
        var curNode = this
        for (char in word) {
            if (char !in curNode.links) {
                curNode[char] = TrieNode()
            }
            curNode = curNode[char]
        }
        curNode.isEnd = true
    }

    fun hasWord(word: String): Boolean {
        var curNode = this
        for (char in word) {
            if (char !in curNode.links) {
                return false
            }
            curNode = curNode[char]
        }
        return curNode.isEnd
    }

    fun search(word: String): Boolean {
        var curNode = this
        for ((index, char) in word.withIndex()) {
            if (char != WILDCARD_CHAR) {
                if (char !in curNode.links) {
                    return false
                }
                curNode = curNode[char]
            } else {
                for (curLink in curNode.links.values) {
                    if (curLink.search(word.substring(index + 1))) {
                        return true
                    }
                }
                return false
            }
        }
        return curNode.isEnd
    }

    fun containsKey(key: Char): Boolean {
        return links[key] != null
    }

    operator fun get(key: Char): TrieNode {
        return links[key] ?: error("Key not found")
    }

    operator fun set(key: Char, node: TrieNode) {
        links[key] = node
    }


    override fun toString(): String {
        return "${this.links}"
    }

    companion object {
        private const val WILDCARD_CHAR = '.'
    }

}