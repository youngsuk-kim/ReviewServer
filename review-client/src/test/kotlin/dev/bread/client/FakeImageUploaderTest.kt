package dev.bread.client

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class FakeImageUploaderTest {

    private lateinit var imageUploader: ImageUploader

    @BeforeEach
    fun setUp() {
        imageUploader = FakeImageUploader()
    }

    @Test
    fun `파일 업로드`() {
        imageUploader.execute(setOf(File("test.png")))
    }
}
