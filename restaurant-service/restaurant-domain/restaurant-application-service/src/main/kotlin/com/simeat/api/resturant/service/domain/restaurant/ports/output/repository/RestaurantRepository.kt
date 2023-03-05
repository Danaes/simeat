package com.simeat.api.resturant.service.domain.restaurant.ports.output.repository

import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import java.util.*

interface RestaurantRepository {

    fun save(restaurant: Restaurant): Restaurant?

    fun getAll(): List<Restaurant>

    fun getById(id: UUID): Restaurant?
}