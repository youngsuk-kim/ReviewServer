package dev.bread.client

import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.io.File
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import java.util.logging.Logger

@Component
@Profile(value = ["local", "test"])
class FakeImageUploader : ImageUploader {

    private val log: Logger = Logger.getLogger("FakeImageLoader")

    override fun execute(files: Set<File>) {
        log.info { "<<<<<<<<<< FILE UPLOAD EXECUTE >>>>>>>>>>>>" }
        Thread.sleep(TimeUnit.SECONDS.toSeconds(2L))
        files.forEach { each -> log.info{ "<<Name: ${each.name}>> upload success at ${LocalDateTime.now()}" } }
        log.info { "<<<<<<<<<< FILE UPLOAD FINISH >>>>>>>>>>>>" }
    }
}
