package dev.bread.storage.config

import com.zaxxer.hikari.HikariDataSource
import org.h2.tools.Server
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import javax.sql.DataSource

@Configuration
@Profile("local")
internal class H2Config {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

//    @Bean
//    fun h2TcpServer(): Server {
//        return Server.createTcpServer().start()
//    }

    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    fun dataSource(): DataSource {
        val server: Server = defaultRun(9092)
        if (server.isRunning(true)) {
            log.info("server run success")
        }
        log.info("h2 server url = {}", server.url)
        return HikariDataSource()
    }

    private fun defaultRun(port: Int): Server {
        return Server.createTcpServer(
            "-tcp",
            "-tcpAllowOthers",
            "-ifNotExists",
            "-tcpPort",
            port.toString() + ""
        ).start()
    }
}
