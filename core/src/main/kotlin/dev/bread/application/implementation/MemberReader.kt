package dev.bread.application.implementation

import dev.bread.domain.Member
import dev.bread.domain.MemberRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class MemberReader(
    private val memberRepository: MemberRepository
) {

    @Transactional(readOnly = true)
    fun read(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}