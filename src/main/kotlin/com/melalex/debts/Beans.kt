package com.melalex.debts

import com.melalex.debts.mappers.UserConverter
import org.mapstruct.factory.Mappers
import org.springframework.context.support.beans

fun beans() = beans {
    bean<UserConverter> { Mappers.getMapper(UserConverter::class.java) }
}