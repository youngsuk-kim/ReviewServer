package dev.bread.client

import org.springframework.stereotype.Service
import java.io.File

@Service
class FileService(
    private val imageUploader: ImageUploader
) {

    fun upload(files: Set<File>) {
        imageUploader.execute(files)
    }
}
