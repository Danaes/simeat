package com.simeat.api.application.handler

import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper

interface GlobalExceptionHandler<T: Exception> : ExceptionMapper<T> {
    override fun toResponse(exception: T): Response
}