package kotlin_in_action.backtrack

fun main() {
    val ips = arrayListOf("25525511135", "010010", "1231231231234", "")
    val sol = RestoreIpAddress()
    for (ip in ips) {
        val restoreIpAddresses = sol.restoreIpAddresses(ip)
        println(restoreIpAddresses)
    }
}
class RestoreIpAddress {
    fun restoreIpAddresses(s: String): List<String> {
        if (s.isNullOrEmpty() || s.length > 12) {
            return emptyList()
        }
        val result = arrayListOf<String>()

        fun backtrack(currentIpStr: String, index: Int) {
            if (index == s.length) {
                if (isValidIp(currentIpStr)) {
                    result.add(currentIpStr)
                }
            } else {
                val nextDigit = s[index]
                backtrack("$currentIpStr$nextDigit", index + 1)
                backtrack("$currentIpStr$DELIMITER$nextDigit", index + 1)
            }
        }

        backtrack(s.first().toString(), 1)
        return result
    }

    private fun isValidIp(ip: String): Boolean {
        val ipParts = ip.split(DELIMITER)
        return ipParts.size == 4 && ipParts.all { isValidIpPart(it) }
    }

    private fun isValidIpPart(ipPart: String): Boolean {
        if (ipPart.startsWith("0") && ipPart.length > 1) {
            return false
        }
        return ipPart.isNotEmpty() && ipPart.length <= 3 && ipPart.toInt() <= 255
    }

    companion object {
        private const val DELIMITER = '.'
    }
}