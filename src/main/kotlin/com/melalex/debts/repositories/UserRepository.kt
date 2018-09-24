package com.melalex.debts.repositories

import com.melalex.debts.domain.Debt
import com.melalex.debts.domain.User
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import java.util.*

interface UserRepository : Neo4jRepository<User, Long> {

    @Query("")
    fun findDebts(borrower: User, debtor: User) : Optional<Debt>
}