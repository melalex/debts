package com.melalex.debts.domain

import org.neo4j.ogm.annotation.EndNode
import org.neo4j.ogm.annotation.RelationshipEntity
import org.neo4j.ogm.annotation.StartNode
import javax.money.MonetaryAmount

@RelationshipEntity(type = LENTS)
data class Debt(

        @StartNode
        var borrower: User,

        @EndNode
        var debtor: User,

        var amount: MonetaryAmount
)