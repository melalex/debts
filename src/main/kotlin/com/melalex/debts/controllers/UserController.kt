package com.melalex.debts.controllers

import com.melalex.debts.dto.UserDto
import com.melalex.debts.facades.UserFacade
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userFacade: UserFacade) {

    @GetMapping
    fun findUsersByName(name: String): Flux<UserDto> = userFacade.findUsersByName(name)
}