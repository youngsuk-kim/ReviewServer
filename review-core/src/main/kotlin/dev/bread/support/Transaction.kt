package dev.bread.support

import org.slf4j.Logger
import org.slf4j.LoggerFactory

object Transaction {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    fun <T> start(function: () -> T): T? {
        log.info("<<<<<<<<<< Transaction Start >>>>>>>>>>>>")
        val result = TransactionHandler { function.invoke() }.execute(function)
        log.info("<<<<<<<<<< Transaction Finish >>>>>>>>>>>>")

        return result
    }
}
