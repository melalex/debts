package com.melalex.debts.repositories

import com.melalex.debts.domain.User
import org.springframework.data.neo4j.repository.Neo4jRepository

interface UserRepository : Neo4jRepository<User, Long>