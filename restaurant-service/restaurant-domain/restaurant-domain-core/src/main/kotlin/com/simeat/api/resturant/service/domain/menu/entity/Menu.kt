package com.simeat.api.resturant.service.domain.menu.entity

import com.simeat.api.domain.entity.AggregateRoot
import com.simeat.api.resturant.service.domain.menu.valueobject.MenuId

data class Menu(
    var id: MenuId? = null,
    val name: String,
    val sections: List<Section>? = null
) : AggregateRoot<MenuId>()