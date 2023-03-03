package com.simeat.api.restaurant.service.application.restaurant.rest

import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.ports.input.service.RestaurantApplicationService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/restaurant")
class RestaurantResource {

    @Inject
    lateinit var applicationService: RestaurantApplicationService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun getAll(): Response {
        return Response.accepted().entity("Hello word!").build()
    }

    @POST
    fun createRestaurant(restaurantCreateCmd: RestaurantCreateCmd): Response {
        val response = applicationService.createRestaurant(restaurantCreateCmd)
        return Response.status(Response.Status.CREATED).entity(response).build()
    }
}