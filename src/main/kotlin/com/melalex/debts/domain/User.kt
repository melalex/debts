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
        val id: Long,
        val name: String,

        @Relationship(type = LENTS)
        val debtor: List<User>,

        @Relationship(type = IGNORES)
        val blackList: List<User>
)