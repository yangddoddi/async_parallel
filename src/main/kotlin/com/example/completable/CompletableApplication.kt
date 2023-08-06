package com.example.completable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class CompletableApplication

fun main(args: Array<String>) {
    runApplication<CompletableApplication>(*args)
}
