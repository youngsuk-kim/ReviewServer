package dev.bread.storage.repository

import dev.bread.storage.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaMemberRepository : JpaRepository<MemberEntity, Long>
