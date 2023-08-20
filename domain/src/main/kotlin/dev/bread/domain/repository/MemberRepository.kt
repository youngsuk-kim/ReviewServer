package dev.bread.domain.repository

import dev.bread.domain.Member

interface MemberRepository {
    fun findById(memberId: Long): Member?
}
