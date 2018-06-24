package com.succcubbus.whileelse

public fun <T> While(condition: () -> Boolean, block: () -> T): WhileElseResult<T?> {
    var result: T? = null
    var loops = 0L

    while (condition()) {
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
