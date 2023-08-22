package dev.bread.support

import org.springframework.stereotype.Component
import org.springframework.transaction.support.TransactionTemplate

@Component
class TransactionTemplateHandler<T>(
    private val transactionTemplate: TransactionTemplate
) : TransactionHandler<T> {
    override fun execute(action: TransactionAction<T>): T? {
        return transactionTemplate.execute { action.action() }
    }


}