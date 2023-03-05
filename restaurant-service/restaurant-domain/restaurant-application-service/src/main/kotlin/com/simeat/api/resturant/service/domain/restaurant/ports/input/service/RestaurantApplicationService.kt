package com.simeat.api.resturant.service.domain.restaurant.ports.input.service

import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.dto.RestaurantRes
import javax.validation.Valid

interface RestaurantApplicationService {

    fun createRestaurant(@Valid restaurantCreateCmd: RestaurantCreateCmd): RestaurantRes
    fun getRestaurants(): List<RestaurantRes>
    fun getRestaurantById(id: String): RestaurantRes?
}