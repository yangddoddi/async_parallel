package com.example.completable.controller

import com.example.completable.completable.BlahBlahService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BlahBlahController(
    private val blahBlahService: BlahBlahService
) {
    @GetMapping("/sync")
    fun doWorkWithSynchronous(): List<Any> {
        return blahBlahService.doWorkWithSynchronous()
    }

    @GetMapping("/async")
    fun doWorkWithAsynchronous(): List<Any> {
        return blahBlahService.doWorkWithAsynchronous()
    }
}