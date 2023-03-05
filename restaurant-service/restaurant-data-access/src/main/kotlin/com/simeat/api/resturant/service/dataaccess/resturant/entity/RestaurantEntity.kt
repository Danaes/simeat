package com.simeat.api.resturant.service.dataaccess.resturant.entity

import com.simeat.api.resturant.service.dataaccess.menu.entity.MenuEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "restaurants")
data class RestaurantEntity(
    @Id
    val id: UUID,
    val name: String,
    val address: String,

    @OneToMany(mappedBy = "restaurant", cascade = [CascadeType.ALL])
    val menus: List<MenuEntity>? = null
)
