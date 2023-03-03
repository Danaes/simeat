package com.simeat.api.resturant.service.domain.restaurant.ports.output.repository

import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant

interface RestaurantRepository {

    fun save(restaurant: Restaurant): Restaurant?
}