package kotlin_in_action.structrures.lists

class MyCircularDeque(k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    private var head: ListNode? = null
    private var tail: ListNode? = null
    private val maxSize = k
    private var curSize = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (curSize >= maxSize) {
            return false
        }

        curSize++
        if (head == null && tail == null) {
            head = ListNode(value)
            tail = head
        } else {
            val newHead = ListNode(value)
            head?.prev = newHead
            newHead.next = head
            head = newHead
        }

        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (curSize >= maxSize) {
            return false
        }

        curSize++
        if (head == null && tail == null) {
            head = ListNode(value)
            tail = head
        } else {
            val newTail = ListNode(value)
            tail?.next = newTail
            newTail.prev = tail
            tail = newTail
        }

        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (head == null) {
            return false
        }

        curSize--
        if (head == tail) {
            head = null
            tail = null
        } else {
            head = head?.next
        }

        if (head == tail) {
            tail?.prev = null
        }

        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (tail == null) {
            return false
        }

        curSize--
        if (head == tail) {
            head = null
            tail = null
        } else {
            tail = tail?.prev
        }

        if (head == tail) {
            head?.next = null
        }

        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        return head?.value ?: -1
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        return tail?.value ?: -1
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return curSize == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return curSize == maxSize
    }

    override fun toString(): String {
        return buildString {
            var buf = head
            append("[")
            while (buf != null) {
                append(buf?.value)
                if (buf?.next != null) {
                    print(", ")
                }
                buf = buf.next
            }
            append("]")
        }
    }

    data class ListNode(
        val value: Int,
        var next: ListNode? = null,
        var prev: ListNode? = null
    )

}

