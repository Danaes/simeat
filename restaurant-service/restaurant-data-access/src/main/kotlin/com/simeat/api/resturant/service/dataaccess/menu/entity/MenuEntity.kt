package com.simeat.api.resturant.service.dataaccess.menu.entity

import com.simeat.api.resturant.service.dataaccess.resturant.entity.RestaurantEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "menus")
data class MenuEntity(
    @Id
    val id: UUID,
    val name: String,

    @Id
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "restaurant_id")
    val restaurant: RestaurantEntity
)