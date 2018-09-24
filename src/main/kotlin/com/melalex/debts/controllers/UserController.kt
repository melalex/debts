package com.melalex.debts.controllers

import com.melalex.debts.dto.UserDto
import com.melalex.debts.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userService: UserService) {

    @GetMapping("/ignore")
    fun findUsersByName(name: String): Flux<UserDto> = Flux.empty()
}