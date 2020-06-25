package kotlin_in_action.interview

import java.lang.RuntimeException
import java.util.concurrent.locks.Lock
import kotlin.concurrent.withLock

data class Account(val id: Int, var amount: Int, var lock: Lock)

class NotEnoughMoneyException(message: String) : RuntimeException(message)

fun transfer(from: Account, to: Account, amount: Int) {
    val sortedAccount = listOf(from, to)
        .sortedBy { it.id }
    sortedAccount[0].lock.withLock {
        sortedAccount[1].lock.withLock {
            if (from.amount < amount) {
                throw NotEnoughMoneyException("Required: $amount, available: ${from.amount}")
            }
            from.amount -= amount
            to.amount += amount
        }
    }
}