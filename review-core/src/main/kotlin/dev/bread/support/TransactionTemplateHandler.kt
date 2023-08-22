package dev.bread.support

import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate

@Component
class TransactionTemplateHandler(
    private val transactionTemplate: TransactionTemplate
) : TransactionHandler<Any> {
    override fun execute(action: TransactionAction<Any>): Any? {
        return transactionTemplate.execute { action.action() }
    }
}
