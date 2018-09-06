package com.melalex.debts.dto

import javax.money.MonetaryAmount

data class DebtDto(

        val user: UserDto,
        val amount: MonetaryAmount
)