package com.melalex.debts.services.impl

import com.melalex.debts.domain.User
import com.melalex.debts.repositories.UserRepository
import com.melalex.debts.services.UserService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findUsersByName(name: String): Flux<User> = userRepository.findByName(name)
}