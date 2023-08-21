package dev.bread.application

import dev.bread.domain.Member
import dev.bread.domain.repository.MemberRepository
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class MemberFinder(
    private val memberRepository: MemberRepository
) {

    fun find(memberId: Long): Member {
        return memberRepository.findById(memberId)
            ?: throw CoreException(ErrorType.NOT_FOUND_ERROR)
    }
}
