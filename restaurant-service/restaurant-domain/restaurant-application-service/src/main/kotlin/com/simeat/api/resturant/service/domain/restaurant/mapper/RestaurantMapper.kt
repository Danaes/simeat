package com.simeat.api.resturant.service.domain.restaurant.mapper

import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.dto.RestaurantRes
import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RestaurantMapper {

    fun restaurantCreateCmdToRestaurant(restaurantCreateCmd: RestaurantCreateCmd): Restaurant{
        return Restaurant(
            name = restaurantCreateCmd.name,
            address = restaurantCreateCmd.address
        )
    }

    fun restaurantToRestaurantRes(restaurant: Restaurant): RestaurantRes {
        return RestaurantRes(
            restaurantId = restaurant.id!!.getValue(),
            name = restaurant.name,
            address = restaurant.address,
            menuId = restaurant.menu?.id!!.getValue()
        )
    }
}