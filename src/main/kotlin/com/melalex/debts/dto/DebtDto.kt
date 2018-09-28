package com.melalex.debts.dto

import javax.money.MonetaryAmount

data class DebtDto(

        var user: UserDto,
        var amount: MonetaryAmount
)