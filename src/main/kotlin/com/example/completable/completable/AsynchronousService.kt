package com.example.completable.completable

import com.example.completable.config.logger
import com.example.completable.domain.*
import com.example.completable.repository.*
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
class AsynchronousService(
    private val animalRepository: AnimalRepository,
    private val personRepository: PersonRepository,
    private val kotlinRepository: KotlinRepository,
    private val stupidRepository: StupidRepository,
    private val productRepository: ProductRepository
) {

    @Async
    fun getPeople(): CompletableFuture<List<Person>> {
        logger<AsynchronousService>().info("getPeople() called")
        val result = CompletableFuture.completedFuture(personRepository.findAll())
        logger<AsynchronousService>().info("getPeople() returning")
        return result
    }

    @Async
    fun getAnimals(): CompletableFuture<List<Animal>> {
        logger<AsynchronousService>().info("getAnimals() called")
        val result = CompletableFuture.completedFuture(animalRepository.findAll())
        logger<AsynchronousService>().info("getAnimals() returning")
        return result
    }

    @Async
    fun getKotlin(): CompletableFuture<List<Kotlin>> {
        logger<AsynchronousService>().info("getKotlin() called")
        val result = CompletableFuture.completedFuture(kotlinRepository.findAll())
        logger<AsynchronousService>().info("getKotlin() returning")
        return result
    }

    @Async
    fun getStupids(): CompletableFuture<List<Stupid>> {
        logger<AsynchronousService>().info("getStupids() called")
        val result = CompletableFuture.completedFuture(stupidRepository.findAll())
        logger<AsynchronousService>().info("getStupids() returning")
        return result
    }

    @Async
    fun getProducts(): CompletableFuture<List<Product>> {
        logger<AsynchronousService>().info("getProducts() called")
        val result = CompletableFuture.completedFuture(productRepository.findAll())
        logger<AsynchronousService>().info("getProducts() returning")
        return result
    }
}