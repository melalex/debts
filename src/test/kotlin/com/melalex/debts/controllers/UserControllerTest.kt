package com.melalex.debts.controllers

import com.melalex.debts.domain.User
import com.melalex.debts.dto.UserDto
import com.melalex.debts.repositories.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    private final val user1: User = User(1, "user1", "image1")
    private final val user2: User = User(2, "user2", "image1")

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        userRepository.save(user1)
        userRepository.save(user2)
    }

    @Test
    fun `should return all users`() {
        val dto1 = UserDto(user1.id, user1.name, user1.image)
        val dto2 = UserDto(user2.id, user2.name, user2.image)

        checkFindUsersByNameEndpoint("user", dto1, dto2)
    }

    @Test
    fun `should return users1`() {
        val dto1 = UserDto(user1.id, user1.name, user1.image)

        checkFindUsersByNameEndpoint("user1", dto1)
    }

    private fun checkFindUsersByNameEndpoint(name: String, vararg expected: UserDto) {
        webTestClient.get()
                .uri("/api/v1/users", mapOf("name" to name))
                .exchange()
                .expectBodyList(UserDto::class.java)
                .contains(*expected)
                .hasSize(expected.size)
    }
}