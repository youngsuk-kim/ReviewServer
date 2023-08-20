package dev.bread.storage.repository

import dev.bread.domain.Member
import dev.bread.domain.MemberRepository
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(
    private val jpaMemberRepository: JpaMemberRepository
) : MemberRepository {
    override fun findById(memberId: Long): Member {
        val memberEntity = jpaMemberRepository.findById(memberId)
            .orElseThrow { throw NoSuchElementException("Member not found error occurred.") }

        return Member(id = memberEntity.id!!, name = memberEntity.name)
    }
}
