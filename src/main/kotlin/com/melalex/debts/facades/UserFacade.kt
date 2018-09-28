package com.melalex.debts.facades

import com.melalex.debts.dto.UserDto
import reactor.core.publisher.Flux

interface UserFacade {

    fun findUsersByName(name: String): Flux<UserDto>
}