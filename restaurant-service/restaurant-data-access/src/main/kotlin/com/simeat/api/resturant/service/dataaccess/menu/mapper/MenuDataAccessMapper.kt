package com.simeat.api.resturant.service.dataaccess.menu.mapper

import com.simeat.api.resturant.service.dataaccess.menu.entity.MenuEntity
import com.simeat.api.resturant.service.dataaccess.resturant.entity.RestaurantEntity
import com.simeat.api.resturant.service.domain.menu.entity.Menu
import com.simeat.api.resturant.service.domain.menu.valueobject.MenuId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MenuDataAccessMapper {

    fun toEntities(menus: List<Menu>, restaurantEntity: RestaurantEntity): List<MenuEntity> {
        return menus.map { toEntity(it, restaurantEntity) }
    }

    fun toEntity(menu: Menu, restaurantEntity: RestaurantEntity): MenuEntity{
        return MenuEntity(
            id = menu.id!!.getValue(),
            name = menu.name,
            restaurant = restaurantEntity
        )
    }

    fun toDomain(menuEntities: List<MenuEntity>?): List<Menu>? {
        return menuEntities?.map { Menu(id = MenuId(it.id), name = it.name) }
    }
}