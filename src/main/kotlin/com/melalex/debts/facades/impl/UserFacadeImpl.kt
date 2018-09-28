package com.melalex.debts.facades.impl

import com.melalex.debts.annotations.Facade
import com.melalex.debts.dto.UserDto
import com.melalex.debts.facades.UserFacade
import com.melalex.debts.mappers.UserConverter
import com.melalex.debts.services.UserService
import reactor.core.publisher.Flux

@Facade
class UserFacadeImpl(
        private val userService: UserService,
        private val userConverter: UserConverter
) : UserFacade {

    override fun findUsersByName(name: String): Flux<UserDto> = userService.findUsersByName(name)
            .map(userConverter::toDto)
}