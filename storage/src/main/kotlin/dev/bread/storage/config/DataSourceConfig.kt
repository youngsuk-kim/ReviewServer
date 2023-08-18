package dev.bread.storage.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("live")
internal class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "storage.datasource.core")
    fun coreHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun coreDataSource(@Qualifier("coreHikariConfig") config: HikariConfig): HikariDataSource {
        return HikariDataSource(config)
    }
}
