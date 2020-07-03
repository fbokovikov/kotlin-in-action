package kotlin_in_action.google.easy

fun main() {
    val logger = Logger()
    logger.shouldPrintMessage(1, "foo")
    logger.shouldPrintMessage(2,"bar")
    logger.shouldPrintMessage(3,"foo")
    logger.shouldPrintMessage(8,"bar")
    logger.shouldPrintMessage(10,"foo")
    logger.shouldPrintMessage(11,"foo")
}

class Logger {

    /** Initialize your data structure here. */
    private val messages: MutableMap<String, Int> = HashMap()

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val isNewMessage = !messages.contains(message)
        val isThresholdExceeded = timestamp - messages.getOrDefault(message, 0) >= LOG_THRESHOLD_SEC
        val shouldPrint = isNewMessage || isThresholdExceeded
        if (shouldPrint)
            messages[message] = timestamp
        return shouldPrint
    }

    companion object {
        private const val LOG_THRESHOLD_SEC = 10
    }
}