package com.melalex.debts.mappers

import com.melalex.debts.domain.User
import com.melalex.debts.dto.UserDto
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserConverter {

    fun toDto(user: User): UserDto

    fun toEntity(userDto: UserDto): User
}