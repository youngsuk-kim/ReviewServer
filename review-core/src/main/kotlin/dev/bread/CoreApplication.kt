package dev.bread

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@ConfigurationPropertiesScan
@EnableAspectJAutoProxy
@SpringBootApplication
class CoreApplication

fun main(args: Array<String>) {
    runApplication<CoreApplication>(*args)
}
