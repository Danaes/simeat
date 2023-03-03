package com.simeat.api.resturant.service.domain.menu.entity

import com.simeat.api.domain.entity.AggregateRoot
import com.simeat.api.domain.valueobject.Money
import com.simeat.api.resturant.service.domain.menu.valueobject.ItemId

data class Item(
    var id: ItemId? = null,
    val name: String,
    val description: String? = null,
    val price: Money
) : AggregateRoot<ItemId>()