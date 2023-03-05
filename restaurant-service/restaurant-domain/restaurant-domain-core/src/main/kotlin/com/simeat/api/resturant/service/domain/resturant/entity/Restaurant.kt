package com.simeat.api.resturant.service.domain.resturant.entity

import com.simeat.api.domain.entity.AggregateRoot
import com.simeat.api.resturant.service.domain.menu.entity.Menu
import com.simeat.api.resturant.service.domain.resturant.exception.RestaurantDomainException
import com.simeat.api.resturant.service.domain.resturant.valueobject.RestaurantId
import java.util.*

data class Restaurant(
    var id: RestaurantId? = null,
    val name: String,
    val address: String,
    val menus: List<Menu>? = null
) : AggregateRoot<RestaurantId>() {

    fun validate() {
        if (this.id != null){
            throw RestaurantDomainException("Restaurant is not in correct state for initialization!")
        }
    }

    fun initialize(){
        this.id = RestaurantId(UUID.randomUUID())
    }
}