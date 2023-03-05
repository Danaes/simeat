package com.simeat.api.resturant.service.dataaccess.resturant.mapper

import com.simeat.api.resturant.service.dataaccess.menu.entity.MenuEntity
import com.simeat.api.resturant.service.dataaccess.menu.mapper.MenuDataAccessMapper
import com.simeat.api.resturant.service.dataaccess.resturant.entity.RestaurantEntity
import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import com.simeat.api.resturant.service.domain.resturant.valueobject.RestaurantId
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class RestaurantDataAccessMapper {

    @Inject
    lateinit var menuDataAccessMapper: MenuDataAccessMapper

    fun toEntity(restaurant: Restaurant): RestaurantEntity {
        val restaurantEntity = RestaurantEntity(
            id = restaurant.id!!.getValue(),
            name = restaurant.name,
            address = restaurant.address
        )

        var menus: List<MenuEntity>? = null
        restaurant.menus?.let { menus = menuDataAccessMapper.toEntities(it, restaurantEntity) }

        return restaurantEntity.copy(menus = menus)
    }

    fun toDomain(restaurantEntity: RestaurantEntity): Restaurant {
        return Restaurant(
            id = RestaurantId(restaurantEntity.id),
            name = restaurantEntity.name,
            address = restaurantEntity.address,
            menus = menuDataAccessMapper.toDomain(restaurantEntity.menus)
        )
    }
}