package com.simeat.api.resturant.service.domain.resturant.exception

import com.simeat.api.domain.exception.DomainException

class RestaurantDomainException(override val message: String) : DomainException(message)