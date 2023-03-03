package com.simeat.api.resturant.service.domain.menu.entity

import com.simeat.api.domain.entity.AggregateRoot
import com.simeat.api.resturant.service.domain.menu.valueobject.SectionId

data class Section(
    var id: SectionId? = null,
    val name: String,
    val items: List<Item>? = null
) : AggregateRoot<SectionId>()