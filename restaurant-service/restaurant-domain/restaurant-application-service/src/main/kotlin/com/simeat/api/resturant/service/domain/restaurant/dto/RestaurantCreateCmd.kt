package com.simeat.api.resturant.service.domain.dto

import javax.validation.constraints.NotNull

data class RestaurantCreateCmd (
    @NotNull(message = "name cannot be null")
    val name: String,
    @NotNull(message = "address cannot be null")
    val address: String,
)