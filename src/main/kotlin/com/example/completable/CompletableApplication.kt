package com.example.completable

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CompletableApplication

fun main(args: Array<String>) {
    runApplication<CompletableApplication>(*args)
}
