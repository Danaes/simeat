package com.simeat.api.resturant.service.dataaccess.resturant.adapter

import com.simeat.api.resturant.service.dataaccess.resturant.mapper.RestaurantDataAccessMapper
import com.simeat.api.resturant.service.dataaccess.resturant.repository.RestaurantPanacheRepository
import com.simeat.api.resturant.service.domain.restaurant.ports.output.repository.RestaurantRepository
import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class RestaurantRepositoryImpl : RestaurantRepository {

    @Inject
    lateinit var restaurantPanacheRepository: RestaurantPanacheRepository

    @Inject
    lateinit var restaurantDataAccessMapper: RestaurantDataAccessMapper

    override fun save(restaurant: Restaurant): Restaurant? {
        val restaurantEntity = restaurantDataAccessMapper.toEntity(restaurant)
        restaurantPanacheRepository.persist(restaurantEntity)
        return if (restaurantPanacheRepository.isPersistent(restaurantEntity)) restaurant else null
    }

    override fun getAll(): List<Restaurant> {
        val restaurantEntities = restaurantPanacheRepository.listAll()
        return if (restaurantEntities.isNullOrEmpty())
            emptyList()
        else
            restaurantEntities.map { restaurantDataAccessMapper.toDomain(it) }
    }

    override fun getById(id: UUID): Restaurant? {
        val restaurantEntity = restaurantPanacheRepository.findById(id) ?: return null
        return restaurantDataAccessMapper.toDomain(restaurantEntity)
    }
}