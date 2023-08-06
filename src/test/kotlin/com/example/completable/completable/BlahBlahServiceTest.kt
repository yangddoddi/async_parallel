package com.example.completable.completable

import com.example.completable.config.AsyncConfiguration
import com.example.completable.domain.*
import com.example.completable.repository.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import kotlin.system.measureTimeMillis

@EnableAsync
@SpringBootTest
class BlahBlahServiceTest @Autowired constructor(
    private val blahBlahService: BlahBlahService,
    private val kotlinRepository: KotlinRepository,
    private val personRepository: PersonRepository,
    private val stupidRepository: StupidRepository,
    private val productRepository: ProductRepository,
    private val animalRepository: AnimalRepository
) {

    @BeforeEach
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun setupData() {
        val kotlin = mutableListOf<Kotlin>()
        val people = mutableListOf<Person>()
        val animals = mutableListOf<Animal>()
        val stupids = mutableListOf<Stupid>()
        val products = mutableListOf<Product>()

        for (i in 1 .. 10) {
            kotlin.add(Kotlin.fixture(name = "name$i"))
            people.add(Person.fixture(name = "name$i"))
            animals.add(Animal.fixture(name = "name$i"))
            stupids.add(Stupid.fixture(name = "name$i"))
            products.add(Product.fixture(name = "name$i"))
        }

        kotlinRepository.saveAll(kotlin)
        personRepository.saveAll(people)
        animalRepository.saveAll(animals)
        stupidRepository.saveAll(stupids)
        productRepository.saveAll(products)
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun deleteAllData() {
        kotlinRepository.deleteAll()
        personRepository.deleteAll()
        animalRepository.deleteAll()
        stupidRepository.deleteAll()
        productRepository.deleteAll()
    }

    @Test
    fun test1() {
        val asynchronousTime = measureTimeMillis {
            val result = blahBlahService.doWorkWithAsynchronous()
        }

        deleteAllData()
        println("asynchronousTime: $asynchronousTime")
    }

    @Test
    fun test2() {
        // given when
        val synchronousTime = measureTimeMillis {
            val result = blahBlahService.doWorkWithSynchronous()
        }

        //then
        println("synchronousTime: $synchronousTime")
    }


}