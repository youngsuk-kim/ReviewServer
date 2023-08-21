package dev.bread.client

import java.io.File

interface ImageUploader {
    fun execute(files: List<File>)
}
