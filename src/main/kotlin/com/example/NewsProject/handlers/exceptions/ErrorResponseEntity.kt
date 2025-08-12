package com.example.NewsProject.handlers.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ErrorResponseEntity(
    private val errorMessage: String?,
    private val httpStatus: HttpStatus
): ResponseEntity<Any>(errorMessage, httpStatus) {
    override fun getBody(): Any {
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = System.currentTimeMillis()
        body["status"] = httpStatus.value()
        body["message"] = errorMessage ?: "Error"
        return body
    }
}