package dev.bread.application

import dev.bread.storage.entity.Menu
import dev.bread.storage.repository.MenuRepository
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MenuReader(
    private val menuRepository: MenuRepository
) {
    @Transactional(readOnly = true)
    fun read(menuId: Long): Menu {
        return menuRepository.findById(menuId)
            .orElseThrow { throw CoreException(ErrorType.NOT_FOUND_ERROR) }
    }

    @Transactional(readOnly = true)
    fun read(menuIds: List<Long>): List<Menu>? {
        return menuRepository.findByIdIn(menuIds)
    }
}
