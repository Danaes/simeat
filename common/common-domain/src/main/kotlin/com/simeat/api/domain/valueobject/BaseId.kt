package com.simeat.api.domain.valueobject

abstract class BaseId<T>(
    private val value: T
) {

    fun getValue() = value
}