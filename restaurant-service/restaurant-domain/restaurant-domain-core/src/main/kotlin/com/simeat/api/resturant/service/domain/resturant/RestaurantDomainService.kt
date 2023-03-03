package com.simeat.api.resturant.service.domain.resturant

import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant

interface RestaurantDomainService {

    fun validateAndInitiateRestaurant(restaurant: Restaurant)
}