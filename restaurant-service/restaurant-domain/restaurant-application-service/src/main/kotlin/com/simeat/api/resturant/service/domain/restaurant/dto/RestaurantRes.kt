package com.simeat.api.resturant.service.domain.restaurant.dto

import java.util.*
import javax.validation.constraints.NotNull

data class RestaurantRes(
    @NotNull
    val restaurantId: UUID,
    @NotNull
    val name: String,
    @NotNull
    val address: String,
    val menuIds: List<UUID>?
)
