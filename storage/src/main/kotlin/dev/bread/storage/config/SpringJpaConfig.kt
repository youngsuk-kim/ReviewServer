package dev.bread.storage.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["dev.bread.storage.entity"])
@EnableJpaRepositories(basePackages = ["dev.bread.storage.repository"])
internal class SpringJpaConfig
