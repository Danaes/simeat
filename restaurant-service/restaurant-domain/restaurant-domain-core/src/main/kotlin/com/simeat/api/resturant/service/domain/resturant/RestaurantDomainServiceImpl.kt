package com.simeat.api.resturant.service.domain.resturant

import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RestaurantDomainServiceImpl : RestaurantDomainService {

    override fun validateAndInitiateRestaurant(restaurant: Restaurant) {
        restaurant.validate()
        restaurant.initialize()
    }
}