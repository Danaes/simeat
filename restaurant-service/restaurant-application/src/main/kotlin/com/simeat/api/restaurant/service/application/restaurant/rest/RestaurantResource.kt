package com.simeat.api.restaurant.service.application.restaurant.rest

import com.simeat.api.application.handler.ErrorDto
import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.ports.input.service.RestaurantApplicationService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/restaurant")
@Produces(MediaType.APPLICATION_JSON)
class RestaurantResource {

    @Inject
    lateinit var applicationService: RestaurantApplicationService

    @GET
    fun getAll(): Response {
        return Response.accepted().entity(applicationService.getRestaurants()).build()
    }

    @GET
    @Path(("/{id}"))
    fun getById(@PathParam("id") id: String): Response {
        val restaurantRes = applicationService.getRestaurantById(id)
        return if (restaurantRes != null)
            Response.ok().entity(restaurantRes).build()
        else {
            val notFoundStatusCode = Response.Status.NOT_FOUND
            val message = "Restaurant not exists with id $id"
            Response
                .status(notFoundStatusCode)
                .entity(ErrorDto(code = notFoundStatusCode.reasonPhrase, message = message))
                .build()
        }
    }

    @POST
    fun createRestaurant(restaurantCreateCmd: RestaurantCreateCmd): Response {
        val restaurantRes = applicationService.createRestaurant(restaurantCreateCmd)
        return Response.status(Response.Status.CREATED).entity(restaurantRes).build()
    }
}