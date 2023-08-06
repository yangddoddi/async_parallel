package com.example.completable.completable

import com.example.completable.config.logger
import com.example.completable.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture

@Service
class BlahBlahService(
    private val animalRepository: AnimalRepository,
    private val personRepository: PersonRepository,
    private val kotlinRepository: KotlinRepository,
    private val stupidRepository: StupidRepository,
    private val productRepository: ProductRepository,
    private val asynchronousService: AsynchronousService
) {

    @Transactional(readOnly = true)
    fun doWorkWithSynchronous(): List<Any> {
        val animals = animalRepository.findAll()
        val people = personRepository.findAll()
        val kotlin = kotlinRepository.findAll()
        val stupids = stupidRepository.findAll()
        val products = productRepository.findAll()

        return animals + people + kotlin + stupids + products
    }

    @Transactional(readOnly = true)
    fun doWorkWithAsynchronous(): List<Any> {
        logger<BlahBlahService>().info("doWorkWithAsynchronous() called")
        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling asynchronousService.getAnimals()")
        val animalsFuture = asynchronousService.getAnimals()
        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling asynchronousService.getPeople()")
        val peopleFuture = asynchronousService.getPeople()
        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling asynchronousService.getKotlin()")
        val kotlinFuture = asynchronousService.getKotlin()
        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling asynchronousService.getStupids()")
        val stupidsFuture = asynchronousService.getStupids()
        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling asynchronousService.getProducts()")
        val productsFuture = asynchronousService.getProducts()

        logger<BlahBlahService>().info("doWorkWithAsynchronous() calling CompletableFuture.allOf()")
        CompletableFuture.allOf(
            animalsFuture,
            peopleFuture,
            kotlinFuture,
            stupidsFuture,
            productsFuture
        ).join()
        logger<BlahBlahService>().info("doWorkWithAsynchronous() returning")

        return animalsFuture.get() + peopleFuture.get() + kotlinFuture.get() + stupidsFuture.get() + productsFuture.get()
    }
}