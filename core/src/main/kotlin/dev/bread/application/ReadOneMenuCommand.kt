package dev.bread.application

data class ReadOneMenuCommand(
    val koName: String,
    val enName: String,
    val recommend: Boolean
)
