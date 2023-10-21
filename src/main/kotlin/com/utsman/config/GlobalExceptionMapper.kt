package com.utsman.config

import com.utsman.model.ApplicationResponse
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class GlobalExceptionMapper : ExceptionMapper<Throwable> {
    override fun toResponse(exception: Throwable?): Response {
        exception?.printStackTrace()
        val entityResponse = ApplicationResponse<String>(
            status = false,
            message = exception?.message.orEmpty()
        )
        return Response.status(
            Response.Status.BAD_REQUEST
        )
            .entity(entityResponse)
            .build()
    }
}