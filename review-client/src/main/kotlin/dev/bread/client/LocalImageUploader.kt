package dev.bread.client

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.io.File

@Component
@Profile(value = ["local", "test"])
class LocalImageUploader : ImageUploader {
    override fun execute(files: List<File>) {

    }
}
