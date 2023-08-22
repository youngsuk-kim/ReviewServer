package dev.bread.support

fun interface TransactionAction<T> {
    fun action(): T
}
