package com.simeat.api.domain.exception

open class DomainException(override val message: String) : RuntimeException(message)