package kotlin_in_action.facebook.medium

import kotlin_in_action.structrures.trie.TrieNode

class WordDictionary {

    /** Initialize your data structure here. */
    private val root: TrieNode = TrieNode()

    /** Adds a word into the data structure. */
    fun addWord(word: String) {
        root.addWord(word)
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    fun search(word: String): Boolean {
        return root.search(word)
    }
}