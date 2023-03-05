package com.simeat.api.resturant.service.dataaccess.resturant.repository

import com.simeat.api.resturant.service.dataaccess.resturant.entity.RestaurantEntity
import io.quarkus.hibernate.orm.panache.PanacheRepository
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
interface RestaurantPanacheRepository : PanacheRepository<RestaurantEntity> {

    fun findById(id: UUID): RestaurantEntity? = find("id", id).firstResult() ?: null
}