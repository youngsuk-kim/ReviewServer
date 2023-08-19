package dev.bread.support.error

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class ErrorType(val status: HttpStatus, val code: ErrorCode, val message: String, val logLevel: LogLevel) {
    DEFAULT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.E500, "An unexpected error has occurred.", LogLevel.ERROR),
    NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, ErrorCode.E404, "An not found error has occurred.", LogLevel.INFO);
}
