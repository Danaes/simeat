package com.simeat.api.resturant.service.domain.restaurant.mapper

import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.dto.RestaurantRes
import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RestaurantMapper {

    fun toDomain(restaurantCreateCmd: RestaurantCreateCmd): Restaurant{
        return Restaurant(
            name = restaurantCreateCmd.name,
            address = restaurantCreateCmd.address
        )
    }

    fun toDto(restaurants: List<Restaurant>): List<RestaurantRes> = restaurants.map { toDto(it) }

    fun toDto(restaurant: Restaurant): RestaurantRes {
        return RestaurantRes(
            restaurantId = restaurant.id!!.getValue(),
            name = restaurant.name,
            address = restaurant.address,
            menuIds = restaurant.menus?.map { it.id!!.getValue() }
        )
    }
}