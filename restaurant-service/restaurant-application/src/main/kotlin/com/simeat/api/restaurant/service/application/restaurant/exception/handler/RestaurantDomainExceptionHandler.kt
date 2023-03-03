package com.simeat.api.restaurant.service.application.restaurant.exception.handler

import com.simeat.api.application.handler.ErrorDto
import com.simeat.api.application.handler.GlobalExceptionHandler
import com.simeat.api.resturant.service.domain.resturant.exception.RestaurantDomainException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@Provider
class RestaurantDomainExceptionHandler : GlobalExceptionHandler<RestaurantDomainException>{

    override fun toResponse(exception: RestaurantDomainException): Response {
        val status = Response.Status.BAD_REQUEST
        return Response.status(status)
            .entity(ErrorDto(code = status.reasonPhrase, message = exception.message))
            .build()
    }
}