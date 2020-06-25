package kotlin_in_action.interview.tiny.url

import java.util.concurrent.atomic.AtomicLong
import kotlin.math.pow

class TinyUrlSupplier {

    private val idToUrlMap = hashMapOf<Long, String>()
    private val urlCounter =  AtomicLong(0)

    fun toTinyUrl(url: String): String {
        var curId = urlCounter.incrementAndGet()
        idToUrlMap[curId] = url
        return buildString {
            while (curId > 0) {
                val curChar = URL_CHARS[curId.rem(URL_CHARS.size).toInt()]
                append(curChar)
                curId = curId.div(URL_CHARS.size)
            }
        }
    }

    fun fromTinyUrl(tinyUrl: String): String {
        var id = 0
        for ((index, curChar) in tinyUrl.withIndex()) {
            val curPow = URL_CHARS.size.pow(index)
            id += when (curChar) {
                in 'a'..'z' -> (curChar - 'a') * curPow
                in 'A'..'Z' -> (curChar - 'A' + ALPHABET_SIZE) * curPow
                else ->  (curChar - '0' + 2 * ALPHABET_SIZE) * curPow
            }
        }
        if (id !in idToUrlMap) {
            throw IllegalArgumentException("$tinyUrl not found")
        }
        return idToUrlMap[id]!!
    }

    companion object {
        private val URL_CHARS = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        private const val ALPHABET_SIZE = 26
    }
}

private fun Int.pow(value: Int): Int {
    return this.toDouble().pow(value).toInt()
}