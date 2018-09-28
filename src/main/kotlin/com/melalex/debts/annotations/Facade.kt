package com.melalex.debts.annotations

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class Facade(

        @get:AliasFor(annotation = Component::class)
        val value: String = ""
)