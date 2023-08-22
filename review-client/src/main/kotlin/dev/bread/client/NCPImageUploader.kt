package dev.bread.client

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.io.File

@Component
@Profile("live")
class NCPImageUploader : ImageUploader {
    override fun execute(files: Set<File>) {
        TODO("Not yet implemented")
    }
}
