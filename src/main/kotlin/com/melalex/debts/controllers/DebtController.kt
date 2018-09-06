package com.melalex.debts.controllers

import com.melalex.debts.dto.DebtDto
import com.melalex.debts.services.DebtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/user/current")
class DebtController(val debtService: DebtService) {

    @PostMapping("/borrow")
    fun borrow(debtDto: DebtDto): Mono<DebtDto> = Mono.empty()

    @PostMapping("/borrow")
    fun lend(debtDto: DebtDto): Mono<DebtDto> = Mono.empty()

    @GetMapping("/debts")
    fun getAllDebts(): Flux<DebtDto> = Flux.empty<DebtDto>()

    @GetMapping("/borrowers")
    fun getAllLents(): Flux<DebtDto> = Flux.empty<DebtDto>()
}