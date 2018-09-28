package com.melalex.debts.services

import com.melalex.debts.domain.User
import reactor.core.publisher.Flux

interface UserService {

    fun findUsersByName(name: String): Flux<User>
}