package dev.bread.domain

data class Store(
    val open: Boolean
) {
    fun open(): Boolean {
        return this.open
    }
}
