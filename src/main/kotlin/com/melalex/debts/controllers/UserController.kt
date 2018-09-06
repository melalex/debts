package com.melalex.debts.controllers

import com.melalex.debts.dto.UserDto
import com.melalex.debts.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/users/current")
class UserController(val userService: UserService) {

    @PostMapping("/ignore")
    fun ignore(): Mono<UserDto> = Mono.empty()
}