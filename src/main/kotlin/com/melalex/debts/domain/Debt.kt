package com.melalex.debts.domain

import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import java.math.BigDecimal
import java.util.*
import javax.money.MonetaryAmount

@RelationshipEntity(type = LENTS)
data class Debt(

        @StartNode
        val borrower: User,

        @EndNode
        val debtor: User,

        val amount: MonetaryAmount
)