package com.simeat.api.resturant.service.domain.restaurant

import com.simeat.api.resturant.service.domain.dto.RestaurantCreateCmd
import com.simeat.api.resturant.service.domain.restaurant.dto.RestaurantRes
import com.simeat.api.resturant.service.domain.restaurant.mapper.RestaurantMapper
import com.simeat.api.resturant.service.domain.restaurant.ports.input.service.RestaurantApplicationService
import com.simeat.api.resturant.service.domain.restaurant.ports.output.repository.RestaurantRepository
import com.simeat.api.resturant.service.domain.resturant.RestaurantDomainService
import com.simeat.api.resturant.service.domain.resturant.entity.Restaurant
import com.simeat.api.resturant.service.domain.resturant.exception.RestaurantDomainException
import org.jboss.logging.Logger
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
class RestaurantApplicationServiceImpl(
    private val restaurantDomainService: RestaurantDomainService,
    private val restaurantMapper: RestaurantMapper,
    private val restaurantRepository: RestaurantRepository,
    private val log: Logger
) : RestaurantApplicationService {

    @Transactional
    override fun createRestaurant(restaurantCreateCmd: RestaurantCreateCmd): RestaurantRes {
        val restaurant = restaurantMapper.toDomain(restaurantCreateCmd)
        restaurantDomainService.validateAndInitiateRestaurant(restaurant)
        log.info("Restaurant is created with id: ${restaurant.id!!.getValue()}")
        saveRestaurant(restaurant)
        return restaurantMapper.toDto(restaurant)
    }

    override fun getRestaurants(): List<RestaurantRes> {
        val restaurants = restaurantRepository.getAll()
        return restaurantMapper.toDto(restaurants)
    }

    override fun getRestaurantById(id: String): RestaurantRes? {
        val restaurant = restaurantRepository.getById(UUID.fromString(id))
        return if (restaurant != null) restaurantMapper.toDto(restaurant) else null
    }

    private fun saveRestaurant(restaurant: Restaurant){
        val restaurantSaved = restaurantRepository.save(restaurant)
        if (restaurantSaved == null){
            log.error("Could not save restaurant!")
            throw RestaurantDomainException("Could not save restaurant!")
        }

        log.info("Restaurant is saved with id: ${restaurant.id!!.getValue()}")
    }
}