package dev.bread.domain

interface MemberRepository {
    fun findById(memberId: Long): Member?
}
