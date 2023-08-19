package dev.bread.domain.implementation

import dev.bread.storage.entity.Member
import dev.bread.storage.repository.MemberRepository
import dev.bread.support.error.CoreException
import dev.bread.support.error.ErrorType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun read(memberId: Long): Member {
        return memberRepository.findById(memberId)
            .orElseThrow { throw CoreException(ErrorType.NOT_FOUND_ERROR) }
    }
}
