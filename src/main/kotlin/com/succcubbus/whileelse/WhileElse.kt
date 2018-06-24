package com.succcubbus.whileelse

fun main(args: Array<String>) {
    While(::canHasCookie) {
        println("i got cookie")
    } Else {
        println("i got no cookie :(")
    }
}

fun canHasCookie(): Boolean {
    return Math.random() < 0.6
}

public fun <T> While(condition: () -> Boolean, block: () -> T): WhileElseResult<T?> {
    var result: T? = null
    var loops = 0L

    while(condition()) {
        result = block()
        loops++
    }

    return WhileElseResult(result, loops)
}
public data class WhileElseResult<T>(public val result: T, public val loops: Long) {
    infix fun Else(block: () -> T): T {
        return if (loops == 0L) {
            block()
        } else {
            result
        }
    }

}
