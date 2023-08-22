package dev.bread.support

import org.springframework.stereotype.Component

@Component
fun interface TransactionHandler<T> {
    fun execute(action: TransactionAction<T>): T?
}
