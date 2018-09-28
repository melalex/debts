package com.melalex.debts.domain

import org.neo4j.ogm.annotation.GeneratedValue
import org.neo4j.ogm.annotation.Id
import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

const val LENTS: String = "LENTS"
const val IGNORES: String = "IGNORES"

@NodeEntity
data class User(

        @Id
        @GeneratedValue
        var id: Long = 0,
        var name: String = "",
        var image: String = "",

        @Relationship(type = LENTS)
        var debtor: List<User> = listOf(),

        @Relationship(type = IGNORES)
        var blackList: List<User> = listOf()
)