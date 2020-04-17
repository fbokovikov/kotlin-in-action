package kotlin_in_action.primary

data class Person(val name: String, val age: Int? = null, var isMarried: Boolean = false)

fun main() {
    val persons = listOf(Person("Alice"), Person("Bob", 29))

    val oldest = persons.maxBy { it.age?: 0 }
    println("The oldest is: $oldest")
    oldest?.isMarried = true
    println(oldest)
    val oldestName = when (oldest) {
        Person("Bob", 29, true) -> "Bob"
        else -> "Not bob"
    }
    print(oldestName)
}

fun max(a: Int, b: Int) = if (a > b) a else b