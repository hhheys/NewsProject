package com.example.NewsProject.handlers

import com.example.NewsProject.handlers.exceptions.BadRequestException
import com.example.NewsProject.handlers.exceptions.ErrorResponseEntity
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleException(e: BadRequestException): ErrorResponseEntity{
        return ErrorResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }
}