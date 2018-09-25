package com.melalex.debts.repositories

import com.melalex.debts.domain.Debt
import com.melalex.debts.domain.User
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import java.util.*

// @formatter:off

const val FIND_DEBTS_QUERY: String =
                "MATCH (borrower:User)-[rel:LENTS]->(debtor:User) " +
                "WHERE borrower.id = {0} AND debtor.id = {1} " +
                "RETURN rel"

// @formatter:on

interface UserRepository : Neo4jRepository<User, Long> {

    @Query(FIND_DEBTS_QUERY)
    fun findDebts(borrower: User, debtor: User): Optional<Debt>
}