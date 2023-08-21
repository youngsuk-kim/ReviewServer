package dev.bread.storage.repository

import dev.bread.storage.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long>
