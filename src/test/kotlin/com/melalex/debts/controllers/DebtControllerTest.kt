package com.melalex.debts.controllers

import com.melalex.debts.domain.Debt
import com.melalex.debts.domain.User
import com.melalex.debts.dto.DebtDto
import com.melalex.debts.dto.UserDto
import com.melalex.debts.repositories.UserRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.toMono
import javax.money.Monetary
import javax.money.MonetaryAmount

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DebtControllerIntegrationTest {

    private final val user1: User = User(1, "user1", "image1")
    private final val user2: User = User(2, "user2", "image1")
    private final val amount: MonetaryAmount = Monetary.getDefaultAmountFactory()
            .setCurrency("USD")
            .setNumber(322)
            .create()

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
    fun `should borrow`() {
        callDebtEndpoint("/borrow")

        val actualDebt = userRepository.findDebts(user1, user2)

        assertEquals(Debt(user1, user2, amount), actualDebt)
    }

    @Test
    fun `should lent`() {
        callDebtEndpoint("/lent")

        val actualDebt = userRepository.findDebts(user2, user1)

        assertEquals(Debt(user2, user1, amount), actualDebt)
    }

    private fun callDebtEndpoint(endpoint: String) {
        val actualResponseBody = webTestClient.post()
                .uri("/api/v1/users/$endpoint")
                .body(DebtDto(UserDto(user2.id), amount).toMono(), DebtDto::class.java)
                .exchange()
                .expectBody(DebtDto::class.java)
                .returnResult()
                .responseBody

        assertEquals(DebtDto(UserDto(user2.id, user2.name, user2.name), amount), actualResponseBody)
    }
}